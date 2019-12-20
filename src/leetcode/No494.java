package leetcode;

/**
 * 494. 目标和
 * <p>
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No494 {

  public static void main(String[] args) {
//    System.out.println(new No494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//    System.out.println(new No494().findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3));
//    System.out.println(new No494().findTargetSumWays3(new int[]{1, 1, 1, 1, 1}, 3));
    System.out.println(new No494().findTargetSumWays(new int[]{48, 9, 50, 48, 38, 34, 47, 8, 1, 44, 27, 42, 45, 25, 23, 40, 6, 39, 21, 48}, 29));
    System.out.println(new No494().findTargetSumWays2(new int[]{48, 9, 50, 48, 38, 34, 47, 8, 1, 44, 27, 42, 45, 25, 23, 40, 6, 39, 21, 48}, 29));
    System.out.println(new No494().findTargetSumWays3(new int[]{48, 9, 50, 48, 38, 34, 47, 8, 1, 44, 27, 42, 45, 25, 23, 40, 6, 39, 21, 48}, 29));
  }

  private static long count = 0;

  public int findTargetSumWays(int[] nums, int S) {
    count = 0;
    long startTime = System.currentTimeMillis();
    int result = 0;
    for (int i = 0; i < 2 << nums.length - 1; i++) {
      int sum = 0;
      for (int j = 0; j < nums.length; j++) {
        if ((i & (1 << j)) != 0) {
          sum = sum + nums[j];
        } else {
          sum = sum - nums[j];
        }
        count++;
      }
      if (sum == S) {
        result++;
      }
    }
    System.out.println("costtime: " + (System.currentTimeMillis() - startTime) + ", " + count + ", " + ((2 << nums.length - 1) * nums.length));
    return result;
  }

  public int findTargetSumWays2(int[] nums, int S) {
    count = 0;
    long startTime = System.currentTimeMillis();
    int result = test(nums, S, 0, 0);
    System.out.println("costtime: " + (System.currentTimeMillis() - startTime) + ", " + count + ", " + (2 << nums.length));
    return result;
  }

  private int test(int[] nums, int S, int sum, int i) {
    if (i == nums.length) {
      return sum == S ? 1 : 0;
    }
    count += 2;
    return test(nums, S, sum + nums[i], i + 1) + test(nums, S, sum - nums[i], i + 1);
  }

  public int findTargetSumWays3(int[] nums, int S) {
    count = 0;
    long startTime = System.currentTimeMillis();

    int[][] dp = new int[nums.length][2001];
    dp[0][nums[0] + 1000] = 1;
    dp[0][-nums[0] + 1000] += 1;
    for (int i = 1; i < nums.length; i++) {
      for (int sum = -1000; sum <= 1000; sum++) {
        if (dp[i - 1][sum + 1000] > 0) {
          count += 2;
          dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
          dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
        }
      }
    }
    int result = S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    System.out.println("costtime: " + (System.currentTimeMillis() - startTime) + ", " + count);
    return result;
  }

}
