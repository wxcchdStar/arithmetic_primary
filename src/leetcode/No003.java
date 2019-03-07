package leetcode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 无重复的最长子字符串
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 *
 * @author chenhd
 */
public class No003 {

  public static void main(String[] args) {
//    System.out.println(lengthOfLongestSubstring("pwwkew"));
//    System.out.println(lengthOfLongestSubstring2("pwwkew"));
//    System.out.println(lengthOfLongestSubstring3("tmmzuxt"));
//    System.out.println(lengthOfLongestSubstring3("wpw"));
//    System.out.println(lengthOfLongestSubstring3(" "));
    System.out.println(lengthOfLongestSubstringTwoDistinct("pwwwke"));
  }

  private static int lengthOfLongestSubstring(String s) {
    String result = "";
    String temp = "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int index = temp.indexOf(String.valueOf(c));
      if (index >= 0) {
        if (result.length() < temp.length()) {
          result = temp;
        }
        temp = temp.substring(index + 1) + c;
      } else {
        temp += c;
      }
    }

    if (result.length() < temp.length()) {
      result = temp;
    }

    return result.length();
  }

  private static int lengthOfLongestSubstring2(String s) {
    int result = 0;
    Set<Character> set = new HashSet<>();
    int i = 0;
    int j = 0;
    while (i < s.length() && j < s.length()) {
      if (set.contains(s.charAt(j))) {
        set.remove(s.charAt(i++));
      } else {
        set.add(s.charAt(j++));
        result = Math.max(j - i, result);
      }
    }
    return result;
  }

  private static int lengthOfLongestSubstring3(String s) {
    int result = 0;

    Map<Character, Integer> map = new LinkedHashMap<>();
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int found = map.getOrDefault(c, -1);
      if (found >= j) {
        j = found + 1;
      }
      result = Math.max(result, i - j + 1);
      map.put(c, i);
    }

    return result;
  }

  private static int lengthOfLongestSubstringTwoDistinct(String s) {
    int[] count = new int[256];
    int i = 0, numDistinct = 0, maxLen = 0;
    for (int j = 0; j < s.length(); j++) {
      if (count[s.charAt(j)] == 0) numDistinct++;
      count[s.charAt(j)]++;
      while (numDistinct > 2) {
        count[s.charAt(i)]--;
        if (count[s.charAt(i)] == 0) numDistinct--;
        i++;
      }
      maxLen = Math.max(j - i + 1, maxLen);
      System.out.println(j + " >>> " + s.substring(i, j + 1) + ", len: " + maxLen);
    }
    return maxLen;
  }
}
