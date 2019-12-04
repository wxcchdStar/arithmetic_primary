package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No120 {

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();

    List<Integer> row = new ArrayList<>();
    row.add(2);
    triangle.add(row);

    row = new ArrayList<>();
    row.add(3);
    row.add(4);
    triangle.add(row);

    row = new ArrayList<>();
    row.add(6);
    row.add(5);
    row.add(7);
    triangle.add(row);

    row = new ArrayList<>();
    row.add(4);
    row.add(1);
    row.add(8);
    row.add(3);
    triangle.add(row);

    System.out.println(minimumTotal3(triangle));
  }

  public static int minimumTotal3(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }
    return dp[0];
  }

  public static int minimumTotal2(List<List<Integer>> triangle) {
    int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
      }
    }
    return dp[0][0];
  }

  // 第一种，自底向上+备忘
  private static Integer[][] mem;

  public static int minimumTotal(List<List<Integer>> triangle) {
    mem = new Integer[triangle.size()][triangle.size()];
    return find(triangle, 0, 0);
  }

  private static int find(List<List<Integer>> triangle, int i, int j) {
    if (i + 1 >= triangle.size()) {
      return triangle.get(i).get(j);
    }
    if (mem[i][j] != null) {
      return mem[i][j];
    }
    mem[i][j] = triangle.get(i).get(j) + Math.min(find(triangle, i + 1, j), find(triangle, i + 1, j + 1));
    return mem[i][j];
  }
}
