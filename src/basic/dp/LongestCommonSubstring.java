package basic.dp;

/**
 * 最长公共子串
 */
public class LongestCommonSubstring {

  public static void main(String[] args) {
    char[] str1 = "abcdefq".toCharArray();
    char[] str2 = "cdefab".toCharArray();
    System.out.println(longestOfLCS(str1, str2));
  }

  private static int longestOfLCS(char[] str1, char[] str2) {
    int[][] dp = new int[str1.length + 1][str2.length + 1];
    int res = 0;

    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          res = Math.max(res, dp[i][j]);
        }
      }
    }

    return res;
  }

}
