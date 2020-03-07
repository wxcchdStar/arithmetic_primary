package leetcode;

/**
 * 10. 正则表达式匹配
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author chenhd
 */
public class No010 {

  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a") + "=false");
    System.out.println(isMatch("aa", "a*") + "=true");
    System.out.println(isMatch("ab", ".*") + "=true");
    System.out.println(isMatch("aab", "c*a*b") + "=true");
    System.out.println(isMatch("mississippi", "mis*is*p*.") + "=false");
    System.out.println(isMatch("ab", ".*c") + "=false");
    System.out.println(isMatch("abc", "a*bc") + "=true");
    System.out.println(isMatch("aaa", "a*a") + "=true");
    System.out.println(isMatch("aaa", "a*a*a") + "=true");
    System.out.println(isMatch("aaa", "ab*a*c*a") + "=true");
    System.out.println(isMatch("aa", "*") + "=false");
    System.out.println(isMatch("aa", ".*") + "=true");
  }

  private static boolean isMatch2(String s, String p) {
    if (p.isEmpty()) {
      return s.isEmpty();
    }

    boolean firstMatch = !s.isEmpty()
        && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

    if (p.length() >= 2 && p.charAt(1) == '*') {
      return isMatch(s, p.substring(2))
          || (firstMatch && isMatch(s.substring(1), p));
    } else {
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }


  private static boolean isMatch(String text, String pattern) {
    memo = new Boolean[text.length() + 1][pattern.length() + 1];
    return dp(0, 0, text, pattern);
  }

  private static Boolean[][] memo;

  private static boolean dp(int i, int j, String text, String pattern) {
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    boolean ans;
    if (j == pattern.length()) {
      ans = i == text.length();
    } else {
      boolean first_match = (i < text.length() &&
          (pattern.charAt(j) == text.charAt(i) ||
              pattern.charAt(j) == '.'));

      if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
        ans = (dp(i, j + 2, text, pattern) ||
            first_match && dp(i + 1, j, text, pattern));
      } else {
        ans = first_match && dp(i + 1, j + 1, text, pattern);
      }
    }
    memo[i][j] = ans;
    return ans;
  }
}
