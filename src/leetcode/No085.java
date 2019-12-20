package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85. 最大矩形
 * <p>
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ['1','0','1','0','0'],
 * ['1','0','1','1','1'],
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0']
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No085 {

  public static void main(String[] args) {
    System.out.println(new No085().maximalRectangle(new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    }));
    System.out.println(new No085().maximalRectangle(new char[][]{}));
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;

    int result = 0;
    int[] dp = new int[matrix[0].length];
    for (int j = 0; j < matrix.length; j++) {
      for (int i = 0; i < matrix[0].length; i++) {
        if (matrix[j][i] == '1') {
          dp[i] = dp[i] + 1;
        } else {
          dp[i] = 0;
        }
      }
      result = Math.max(largestRectangleArea(dp), result);
    }
    return result;
  }

  private int largestRectangleArea(int[] heights) {
    int result = 0;

    Stack<Integer> stack = new Stack<>();
    stack.add(-1);

    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
        result = Math.max(result, heights[stack.pop()] * (i - stack.peek() - 1));
      }
      stack.add(i);
    }

    while (stack.peek() != -1) {
      result = Math.max(result, heights[stack.pop()] * (heights.length - stack.peek() - 1));
    }

    return result;
  }
}
