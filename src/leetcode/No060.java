package leetcode;

import java.util.*;

/**
 * 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class No060 {

  public static void main(String[] args) {
//    System.out.println(getPermutation(3, 1));
//    System.out.println(getPermutation(4, 9));
//    System.out.println(getPermutation(3, 5));
    System.out.println(getPermutation(3, 2));
  }

  private static String getPermutation(int n, int k) {
    List<String> list = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      list.add(String.valueOf((char) ('0' + i)));
    }
    String str = "";

    int t = n - 1;
    while (k != 0) {
      int jd = jiecheng(t);
      int position = (int) Math.ceil(1.0 * k / jd);

      str += list.get(position - 1);
      list.remove(position - 1);

      k = k % jd;
      t--;
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      str += list.get(i);
    }

    return str;
  }

  private static int jiecheng(int n) {
    if (n == 0) return 1;

    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

}
