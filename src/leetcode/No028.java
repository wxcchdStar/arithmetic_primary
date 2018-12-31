package leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author chenhd
 */
public class No028 {

  public static void main(String[] args) {
//    System.out.println(strStr("hello", "ll"));
//    System.out.println(strStr("", ""));
//    System.out.println(strStr("aabaaabaaac", "aabaaac"));
    System.out.println(indexOf("aabaaabaaac".toCharArray(), "aabaaac".toCharArray()));
  }

  private static int strStr(String haystack, String needle) {
    int[] next = getNext(needle);
    int i = 0, j = 0;
    while (i < haystack.length() && j < needle.length()) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        if (j != 0) {
          j = next[j];
        } else {
          i++;
        }
      }
    }
    if (j == needle.length()) {
      return i - j;
    }
    return -1;
  }

  private static int[] getNext(String pattern) {
    if (pattern.isEmpty()) return new int[]{0};
    int[] next = new int[pattern.length() + 1];
    next[0] = next[1] = 0;
    for (int i = 1; i < pattern.length(); i++) {
      int j = next[i];
      while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
        j = next[j];
      }
      if (pattern.charAt(i) == pattern.charAt(j)) {
        j++;
      }
      next[i + 1] = j;
    }
    return next;
  }

  private static int indexOf(char[] source,
                             char[] target) {
    int sourceCount = source.length;
    int targetCount = target.length;

    if (0 >= sourceCount) {
      return (targetCount == 0 ? sourceCount : -1);
    }

    if (targetCount == 0) {
      return 0;
    }

    char first = target[0];
    int max = (sourceCount - targetCount);

    for (int i = 0; i <= max; i++) {
      /* Look for first character. */
      if (source[i] != first) {
        while (++i <= max && source[i] != first) ;
      }

      System.out.println(String.valueOf(source).substring(0, i + 1));

      /* Found first character, now look at the rest of v2 */
      if (i <= max) {
        int j = i + 1;
        int end = j + targetCount - 1;
        for (int k = 1; j < end && source[j] == target[k]; j++, k++);
        if (j == end) {
          /* Found whole string. */
          return i;
        }
      }
    }
    return -1;
  }
}
