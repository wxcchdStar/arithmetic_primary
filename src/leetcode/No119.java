package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class No119 {

  public static void main(String[] args) {
    System.out.println(new No119().getRow(33));
  }

  static Integer[][] mem = new Integer[35][35];

  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<>();
    for (int i = 1; i <= rowIndex + 1; i++) {
      for (int j = 1; j <= i; j++) {
        int n = test(i, j, mem);
        if (i == rowIndex + 1) {
          row.add(n);
        }
      }
    }
    return row;
  }

  private int test(int i, int j, Integer[][] mem) {
    if (mem[i][j] != null) {
      return mem[i][j];
    }
    if (j == 1 || j == i) {
      mem[i][j] = 1;
      return 1;
    }
    mem[i][j] = test(i - 1, j - 1, mem) + test(i - 1, j, mem);
    return mem[i][j];
  }
}
