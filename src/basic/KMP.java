package basic;

public class KMP {

  public static void main(String[] args) {
    String str = "ABCABCE";
    String pattern = "ABCE";
    System.out.println(bruteForce(str, pattern));
    System.out.println(kmp(str, pattern));
  }

  /**
   * 最坏情况：(n - m + 1) * m，若m=n/2，则最坏时间复杂度为n²
   *
   */
  private static int bruteForce(String str, String pattern) {
    int n = str.length();
    int m = pattern.length();
    for (int i = 0; i <= n - m; i++) {
      int j = 0;
      while (j < m) {
        if (str.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
        j++;
      }
      if (j == m) {
        return i;
      }
    }
    return -1;
  }

  //TODO: KMP
  private static int kmp(String str, String pattern) {

    return -1;
  }
}
