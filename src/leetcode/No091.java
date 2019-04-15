package leetcode;

import java.util.Arrays;

/**
 * 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class No091 {

  public static void main(String[] args) {
    System.out.println(numDecodings("12"));
    System.out.println(numDecodings("226"));
    System.out.println(numDecodings("0"));
    System.out.println(numDecodings("10"));
    System.out.println(numDecodings("27"));
    System.out.println(numDecodings("00"));
    System.out.println(numDecodings("0003"));
    System.out.println(numDecodings("01"));
    System.out.println(numDecodings("100"));
    System.out.println(numDecodings("101"));
    System.out.println(numDecodings("227"));
  }

  private static int numDecodings(String s) {
    int[] dp = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      boolean isZero = s.charAt(i) == '0';
      if (i == 0) {
        dp[i] = isZero ? 0 : 1;
      } else {
        int n = Integer.parseInt(s.substring(i - 1, i + 1));
        if (n > 26) {
          dp[i] = isZero ? 0 : dp[i - 1];
        } else {
          if (i >= 2) {
            if (s.charAt(i - 1) == '0') {
              dp[i] = isZero ? 0 : dp[i - 1];
            } else {
              if (isZero) {
                dp[i] = dp[i - 2];
              } else {
                dp[i] = dp[i - 1] + dp[i - 2];
              }
            }
          } else {
            dp[i] = isZero ? dp[i - 1] : (n < 10 ? 0 : 2);
          }
        }
      }
    }

    return dp[s.length() - 1];
  }
}
