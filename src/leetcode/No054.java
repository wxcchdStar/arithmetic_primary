package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class No054 {

  public static void main(String[] args) {
    System.out.println(new No054().spiralOrder2(new int[][]{
        {1, 2, 3},
        {8, 9, 4},
        {7, 6, 5}
    }));
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0) {
      return result;
    }

    int[][] way = new int[][]{
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    int wayIndex = 0;
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    int i = 0, j = 0;
    int count = 1;

    while (count < matrix.length * matrix[0].length) {
      result.add(matrix[i][j]);
      visited[i][j] = true;
      count++;

      int nextI = i + way[wayIndex][0];
      int nextJ = j + way[wayIndex][1];
      if (nextI >= 0 && nextI < matrix.length && nextJ >= 0 && nextJ < matrix[0].length && !visited[nextI][nextJ]) {
        i = nextI;
        j = nextJ;
      } else {
        wayIndex = (wayIndex + 1) % 4;
        i += way[wayIndex][0];
        j += way[wayIndex][1];
      }
    }

    return result;
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0) {
      return result;
    }
    // 上下
    int r1 = 0, r2 = matrix.length - 1;
    // 左右
    int c1 = 0, c2 = matrix[0].length - 1;

    while (r1 <= r2 && c1 <= c2) {
      // 左
      for (int c = c1; c <= c2; c++) {
        result.add(matrix[r1][c]);
      }
      // 下
      for (int r = r1 + 1; r <= r2; r++) {
        result.add(matrix[r][c2]);
      }
      // 右
      for (int c = c2 - 1; c > c1; c--) {
        result.add(matrix[r2][c]);
      }
      // 上
      for (int r = r2; r > r1; r--) {
        result.add(matrix[r][c1]);
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return result;
  }
}
