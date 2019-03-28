package leetcode;

import java.util.Arrays;

/**
 * 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class No213 {

  public static void main(String[] args) {
//    System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
//    System.out.println(rob(new int[]{2, 1, 1, 2}));
//    System.out.println(rob(new int[]{2, 3, 2}));
    System.out.println(rob(new int[]{1, 2, 1, 1}));
  }

  private static int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);

    int[] dp = test(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(dp));
    int[] dp1 = test(nums, 1, nums.length);
    System.out.println(Arrays.toString(dp1));

    return Math.max(
        Math.max(dp[nums.length - 2], dp[nums.length - 3]),
        Math.max(dp1[nums.length - 1], dp1[nums.length - 2])
    );
  }

  private static int[] test(int[] nums, int start, int end) {
    int[] dp = new int[nums.length];
    for (int i = start; i < end; i++) {
      if (i == 0 || i == 1) {
        dp[i] = nums[i];
      } else if (i == 2) {
        dp[i] = nums[i] + dp[i - 2];
      } else {
        dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
      }
    }
    return dp;
  }

}
