package leetcode;

import java.util.Arrays;

/**
 * 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class No063 {

  public static void main(String[] args) {
    System.out.println(uniquePathsWithObstacles(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    }));
    System.out.println(uniquePathsWithObstacles(new int[][]{
        {0, 0},
        {0, 1},
        {0, 0}
    }));
    System.out.println(uniquePathsWithObstacles(new int[][]{
        {1},
    }));
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 0) {
        arr[i][0] = 1;
      } else {
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      if (obstacleGrid[0][i] == 0) {
        arr[0][i] = 1;
      } else {
        break;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 0) {
          arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
        }
      }
    }

    return arr[m - 1][n - 1];
  }
}
