package leetcode;

/**
 * 翻转字符串
 */
public class No151 {

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
    System.out.println(reverseWords("  hello world!  "));
  }

  public static String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    int j = s.length();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        j = i;
      } else if (i == 0 || s.charAt(i - 1) == ' ') {
        if (result.length() != 0) {
          result.append(" ");
        }
        result.append(s.substring(i, j));
      }
    }
    return result.toString();
  }
}
