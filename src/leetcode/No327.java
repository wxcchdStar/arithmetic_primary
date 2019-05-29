package leetcode;

import java.util.Arrays;

/**
 * 区间和的个数
 * <p>
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 */
public class No327 {

  public static void main(String[] args) {
//    System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2));
//    System.out.println(countRangeSum(new int[]{-1, 1}, 0, 0));
    System.out.println(countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
  }

  private static int countRangeSum(int[] nums, int lower, int upper) {
    long[] BIT = new long[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      int k = i + 1;
      while (k <= nums.length) {
        BIT[k] += nums[i];
        k += (k & -k);
      }
    }
//    System.out.println(Arrays.toString(BIT));

    int result = 0;



    return result;
  }

  private static long getSum(long[] BIT, int i) {
    long sum = 0;
    i++;
    while (i > 0) {
      sum += BIT[i];
      i -= i & -i;
    }
    return sum;
  }
}
