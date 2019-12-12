package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No438 {

  public static void main(String[] args) {
//    System.out.println(new No438().findAnagrams("cbaebabacd", "abc"));
    System.out.println(new No438().findAnagrams("abaacbabc", "abc"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    HashMap<Character, Integer> needs = new HashMap<>(p.length());
    for (char c : p.toCharArray()) {
      needs.put(c, needs.getOrDefault(c, 0) + 1);
    }

    HashMap<Character, Integer> window = new HashMap<>(p.length());
    int count = 0;

    int j = 0;
    int i = 0;

    while (i < s.length()) {

      char current = s.charAt(i);
      if (needs.containsKey(current)) {
        window.put(current, window.getOrDefault(current, 0) + 1);
        if ((int) window.getOrDefault(current, 0) == needs.getOrDefault(current, 0)) {
          count++;
        }

        while (count == needs.size()) {
//          System.out.println(j + "," + i + "=" + s.substring(j, i + 1));
          if (i + 1 - j == p.length()) {
            result.add(j);
          }
          char aChar = s.charAt(j);
          if (window.containsKey(aChar)) {
            int itemNum = window.getOrDefault(aChar, 0) - 1;
            if (itemNum <= 0) {
              window.remove(aChar);
            } else {
              window.put(aChar, itemNum);
            }

//            System.out.println("\t" + aChar + ":" + window.getOrDefault(aChar, 0) + "," + needs.getOrDefault(aChar, 0)
//                + "\t" + count + "," + needs.size());
            if ((int) window.getOrDefault(aChar, 0) < needs.getOrDefault(aChar, 0)) {
              count--;
            }
          }
          j++;
        }
//        System.out.println("---------------");

      }

      i++;
    }

    return result;
  }
}
