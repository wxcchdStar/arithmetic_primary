package basic;

import java.util.Arrays;

public class KMP {

  public static void main(String[] args) {
    String str = "BBC ABCDAB ABCDABCDABDE";
    String pattern = "ABCDABD";
//    System.out.println(Arrays.toString(getNext(pattern)));
//    System.out.println(Arrays.toString(getNext("CDCCDD")));
//    System.out.println(str.indexOf(pattern));
//    System.out.println(bruteForce(str, pattern));
    System.out.println(kmp(str, pattern));
  }

  /**
   * 最坏情况：(n - m + 1) * m，若m=n/2，则最坏时间复杂度为n²
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

  private static int kmp(String str, String pattern) {
    int[] next = getNext(pattern);
    System.out.println(Arrays.toString(next));
    int i = 0, j = 0;

    while (i < str.length() && j < pattern.length()) {
      if (str.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
//        System.out.println(str.substring(0, i + 1) + "| |" + pattern.substring(0, j + 1) + " >>> " + next[j]);
        if (j != 0) {
          j = next[j];
        } else {
          i++;
        }
      }
    }

    if (j == pattern.length()) {
      return i - pattern.length();
    }
    return -1;
  }

  private static int[] getNext(String find) {
    int[] next = new int[find.length() + 1];
    next[0] = next[1] = 0;
    for (int i = 1; i < find.length(); i++) {
      int j = next[i];
      while (j > 0 && (find.charAt(i) != find.charAt(j))) {
        j = next[j];
      }
      int temp = j;
      if (find.charAt(i) == find.charAt(j)) {
        j++;
      }
      System.out.println((i) + "-" + temp + " > " + j + ", " + find.substring(0, i + 1));
      next[i + 1] = j;
    }
    return next;
  }

}
