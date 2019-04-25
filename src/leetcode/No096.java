package leetcode;

/**
 * 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class No096 {

  public static void main(String[] args) {
    System.out.println(numTrees(3));
  }

  private static int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int k = 2; k <= n; k++) {
      for (int i = 1; i <= k; i++) {
        dp[k] += dp[i - 1] * dp[k - i];
      }
    }

    return dp[n];
  }
}
