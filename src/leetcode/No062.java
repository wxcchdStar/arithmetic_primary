package leetcode;

import java.util.Arrays;

/**
 * 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class No062 {

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 2));
    System.out.println(uniquePaths(7, 3));
  }

  public static int uniquePaths(int m, int n) {
    if (m == 1 || n == 1) return 1;

    int[][] arr = new int[m + 1][n + 1];
    Arrays.fill(arr[1], 1);
    for (int i = 0; i <= m; i++) {
      arr[i][1] = 1;
    }

    for (int i = 2; i <= m; i++) {
      for (int j = 2; j <= n; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
      }
    }

    return arr[m][n];
  }
}
