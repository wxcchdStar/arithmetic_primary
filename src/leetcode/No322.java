package leetcode;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No322 {

  public static void main(String[] args) {
    System.out.println(new No322().coinChange(new int[]{2}, 3));
  }

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;

    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
      dp[i] = amount + 1;
      for (int coin : coins) {
        if (i >= coin) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }
    return dp[amount] <= amount ? dp[amount] : -1;
  }
}
