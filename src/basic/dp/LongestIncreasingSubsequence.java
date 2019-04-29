package basic.dp;

/**
 * 最长上升子序列
 */
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    System.out.println(lengthOfLIS(new int[]{-2, -1}));
  }

  private static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) return 0;

    int result = 1;
    int[] dp = new int[nums.length];
    dp[0] = 1;
    // F(k)为状态，F(k-1)为子问题
    for (int i = 1; i < nums.length; i++) {
      // 计算F(k-1)的最大值
      int temp = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          // 与计算好的结果比较，选出最大的
          temp = Math.max(temp, dp[j]);
        }
      }
      // 从F(k-1)计算出最大值并加一
      dp[i] = temp + 1;
      result = Math.max(result, dp[i]);
    }

    return result;
  }


}
