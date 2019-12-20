package leetcode;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 */
public class No084 {

  public static void main(String[] args) {
    System.out.println(new No084().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }

  public int largestRectangleArea(int[] heights) {
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
