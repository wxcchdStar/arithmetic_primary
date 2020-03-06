package leetcode;

/**
 * 最长回文子字符串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author chenhd
 */
public class No005 {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("a"));
    System.out.println(longestPalindrome2(""));
  }

  // 插入"#"号法
  // 实现省略……

  // 暴力法
  private static String longestPalindrome(String s) {
    if (s.length() <= 1) {
      return s;
    }

    String str = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String tmp = s.substring(i, j);
        if (isPalindromeString(tmp) && tmp.length() > str.length()) {
          str = tmp;
        }
      }
    }
    return str;
  }

  private static boolean isPalindromeString(String str) {
    int l, r, m = str.length() / 2;
    if (str.length() % 2 == 0) {
      l = m - 1;
      r = m;
    } else {
      l = m - 1;
      r = m + 1;
    }
    while (l >= 0 && r < str.length()) {
      if (str.charAt(l) == str.charAt(r)) {
        l--;
        r++;
      } else {
        return false;
      }
    }
    return true;
  }

  // 扩展两侧法
  private static String longestPalindrome2(String s) {
    if ("".equals(s)) {
      return "";
    }
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      } else {
        break;
      }
    }
    return right - left - 1;
  }
}
