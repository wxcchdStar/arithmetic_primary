package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 矩阵中的最长递增路径
 * <p>
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class No329_2 {

  public static void main(String[] args) {
    System.out.println(longestIncreasingPath(new int[][]{
        {3, 4, 5},
        {3, 2, 6},
        {2, 2, 1}
    }));
  }

  private static int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int[][] visited = new int[matrix.length][matrix[0].length];

    int result = 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(result, dfs(matrix, visited, i, j));
      }
    }
    return result;
  }

  private static int[][] direction = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  private static int dfs(int[][] matrix, int[][] visited, int x, int y) {
    if (visited[x][y] != 0) {
      return visited[x][y];
    }

    int result = 1;
    for (int i = 0; i < direction.length; i++) {
      int newX = x + direction[i][0];
      int newY = y + direction[i][1];
      if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
        if (matrix[newX][newY] > matrix[x][y]) {
          result = Math.max(result, 1 + dfs(matrix, visited, newX, newY));
        }
      }
    }
    visited[x][y] = result;
    return result;
  }
}
