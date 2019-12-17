package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class No118 {

  public static void main(String[] args) {
    for (List<Integer> row : new No118().generate(5)) {
      System.out.println(Arrays.toString(row.toArray()));
    }
  }

  public List<List<Integer>> generate(int numRows) {
    Integer[][] mem = new Integer[numRows + 1][numRows + 1];

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i <= numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        row.add(test(i, j, mem));
      }
      result.add(row);
    }
    return result;
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
