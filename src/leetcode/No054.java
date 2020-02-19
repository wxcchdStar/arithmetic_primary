package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class No054 {

  public static void main(String[] args) {
    System.out.println(new No054().spiralOrder(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    }));
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0) {
      return result;
    }
    int r1 = 0, r2 = matrix.length - 1;
    int c1 = 0, c2 = matrix[0].length - 1;

    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) {
        result.add(matrix[r1][c]);
      }
      for (int r = r1 + 1; r <= r2; r++) {
        result.add(matrix[r][c2]);
      }
      if (r1 < r2 && c1 < c2) {
        for (int c = c2 - 1; c > c1; c--) {
          result.add(matrix[r2][c]);
        }
        for (int r = r2; r > r1; r--) {
          result.add(matrix[r][c1]);
        }
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return result;
  }
}
