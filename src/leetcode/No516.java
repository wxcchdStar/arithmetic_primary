package leetcode;

/**
 * 最长回文子序列
 * <p>
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 */
public class No516 {

  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq2("bbbab"));
//    System.out.println(longestPalindromeSubseq("cbbd"));
  }

  private static int longestPalindromeSubseq2(String s) {
    int[][] dp = new int[s.length()][s.length()];

    for (int i = s.length() - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i+1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i+1][j-1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }
    return dp[0][s.length()-1];
  }

  private static int longestPalindromeSubseq(String s) {
    String newStr = "";
    for (int i = 0; i < s.length(); i++) {
      newStr += "#" + s.charAt(i);
    }
    newStr += "#";

    int result = 0;

    for (int i = 0; i < newStr.length(); i++) {
      int j = 1;
      int len = newStr.charAt(i) != '#' ? 1 : 0;
      while (i - j >= 0 && i + j < newStr.length()) {
        if (newStr.charAt(i - j) == newStr.charAt(i + j)) {
          if (newStr.charAt(i - j) != '#') {
            len += 2;
          }
          j++;
        } else {
          break;
        }
      }
      result = Math.max(result, len);
    }

    return result;
  }
}
