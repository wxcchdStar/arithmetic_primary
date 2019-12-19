package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 279. 完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No279 {

  public static void main(String[] args) {
    System.out.println(new No279().numSquares(12));
    System.out.println(new No279().numSquares(13));
    System.out.println(new No279().numSquares(1));
  }

  // BFS解法
  public int numSquares(int n) {
    if (n <= 0) return 0;

    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      int m = i * i;
      if (m < n) {
        list.add(m);
      } else if (m == n) {
        return 1;
      } else {
        break;
      }
    }

    int depth = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      depth++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int m = queue.poll();
        for (int j = 0; j < list.size(); j++) {
          int sum = m + list.get(j);
          if (sum == n) {
            return depth;
          } else if (sum < n) {
            queue.add(sum);
          }
        }
      }
    }
    return 0;
  }

  // 动态规划解法
  public int numSquares2(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = i; // 最坏的情况就是每次+1
      for (int j = 1; i - j * j >= 0; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
      }
    }
    return dp[n];
  }

}
