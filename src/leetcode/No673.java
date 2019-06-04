package leetcode;

/**
 * 最长递增子序列的个数
 */
public class No673 {

  public static void main(String[] args) {
    System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
  }

  private static int findNumberOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = count[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[i] == dp[j] + 1) {
            count[i] += count[j];
          } else if (dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
            count[i] = count[j];
          }
        }
      }
    }

    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > max) {
        max = dp[i];
      }
    }

    int result = 0;
    for (int i = 0; i < dp.length; i++) {
      if (max == dp[i]) {
        result += count[i];
      }
    }
    return result;
  }
}
