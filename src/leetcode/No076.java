package leetcode;

import java.util.*;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No076 {

  public static void main(String[] args) {
//    System.out.println(new No076().minWindow("ADOBECODEBANC", "ABC"));
//    System.out.println(new No076().minWindow("aa", "aa"));
    System.out.println(new No076().minWindow("a", "a"));
  }

  // 滑动窗口，左右指针根据特定条件滑动
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>(t.length());
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    HashMap<Character, Integer> window = new HashMap<>(t.length());
    int count = 0;

    String result = "";
    int left = 0;
    int right = 0;

    while (right < s.length()) {
      char current = s.charAt(right);
      if (map.containsKey(current)) {

        window.put(current, window.getOrDefault(current, 0) + 1);
        if ((int) window.getOrDefault(current, 0) == map.getOrDefault(current, 0)) {
          count++;
        }

        while (count == map.size()) {
          int len = result.length() == 0 ? s.length() + 1 : result.length();
          if (right + 1 - left < len) {
            result = s.substring(left, right + 1);
          }

          char c = s.charAt(left);
          if (window.containsKey(c)) {
            int itemNum = window.getOrDefault(c, 0) - 1;
            if (itemNum <= 0) {
              window.remove(c);
            } else {
              window.put(c, itemNum);
            }
            if (window.getOrDefault(c, 0) < map.getOrDefault(c, 0)) {
              count--;
            }
          }

          left++;
        }
      }

      right++;
    }

    return result;
  }
}
