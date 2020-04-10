package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264. 丑数 II
 * <p>
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class No264 {

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(nthUglyNumber(i));
    }
  }

  static int[] results = new int[1690];

  static {
    long[] nums = new long[]{2, 3, 5};

    HashSet<Long> set = new HashSet<>();
    set.add(1L);
    PriorityQueue<Long> queue = new PriorityQueue<>();
    queue.add(1L);

    int count = 1;
    while (count <= 1690) {
      long currentMin = queue.remove();
      results[count - 1] = (int) currentMin;

      count++;

      for (long num : nums) {
        long x = currentMin * num;
        if (!set.contains(x)) {
          queue.add(x);
          set.add(x);
        }
      }
    }
  }

  public static int nthUglyNumber(int n) {
    return results[n - 1];
  }
}
