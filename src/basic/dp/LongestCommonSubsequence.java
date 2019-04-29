package basic.dp;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {

  public static void main(String[] args) {
    char[] str1 = "abcicba".toCharArray();
    char[] str2 = "abdkscba".toCharArray();
    int[][] dp = longestOfLCS(str1, str2);
    System.out.println(getLCS(str1, str2, dp));
  }

  private static int[][] longestOfLCS(char[] str1, char[] str2) {
    int[][] dp = new int[str1.length + 1][str2.length + 1];

    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp;
  }

  private static String getLCS(char[] str1, char[] str2, int[][] dp) {
    int i = str1.length;
    int j = str2.length;
    int size = dp[i][j];
    char[] result = new char[size];

    while (size > 0) {
      if (str1[i - 1] == str2[j - 1]) {
        result[size - 1] = str1[i - 1];
        i--;
        j--;
        size--;
      } else if (dp[i][j - 1] > dp[i - 1][j]) {
        j--;
      } else {
        i--;
      }
    }

    return String.valueOf(result);
  }
}
