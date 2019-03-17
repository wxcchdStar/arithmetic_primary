package leetcode;

/**
 * 使用最小花费爬楼梯
 * <p>
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * 示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * <p>
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class No746 {

  public static void main(String[] args) {
    System.out.println(minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
  }

  private static int minCostClimbingStairs(int[] cost) {
    if (cost.length <= 2) return Math.min(cost[0], cost[1]);

    int a = 0;
    int b = 0;

    for (int i = 2; i <= cost.length; i++) {
      int min = Math.min(cost[i - 2] + a, cost[i - 1] + b);
      a = b;
      b = min;
    }

    return b;
  }

  private static int minCostClimbingStairs2(int[] cost) {
    if (cost.length <= 2) return Math.min(cost[0], cost[1]);

    int[] dp = new int[cost.length];
    dp[0] = cost[0];
    dp[1] = cost[1];

    int result = 0;

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.min(cost[i] + dp[i - 2], cost[i] + dp[i - 1]);
    }

    return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
  }

}
