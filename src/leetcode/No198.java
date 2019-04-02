package leetcode;

import java.util.Arrays;

/**
 * 打家劫舍
 */
public class No198 {

  public static void main(String[] args) {
//    System.out.println(rob(new int[]{2, 1, 1, 2}));
    System.out.println(rob(new int[]{2, 1, 1, 1, 1, 5}));
  }

  public static int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || i == 1) {
        dp[i] = nums[i];
      } else if (i == 2) {
        dp[i] = nums[i] + dp[i - 2];
      } else {
        dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
      }
    }
    System.out.println(Arrays.toString(dp));
    return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
  }
}
