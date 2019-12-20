package leetcode;

import java.util.Arrays;

/**
 * 542. 01 矩阵
 * <p>
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No542 {

  public static void main(String[] args) {
    int[][] result = new No542().updateMatrix2(new int[][]{
//        {0}, {1}
        {0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}
    });
    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public int[][] updateMatrix2(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int[] arr : dp) {
      Arrays.fill(arr, Integer.MAX_VALUE - 10000);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0) {
          if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
          if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (matrix[i][j] != 0) {
          if (i < matrix.length - 1) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
          if (j < matrix[0].length - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return dp;
  }

}
