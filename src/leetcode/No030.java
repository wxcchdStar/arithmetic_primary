package leetcode;

import java.util.*;

/**
 * 与所有单词相关联的字串
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2:
 * <p>
 * 输入:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * 输出: []
 *
 * @author chenhd
 */
public class No030 {

  public static void main(String[] args) {
//    System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//    System.out.println(findSubstring("wordgoodstudentgoodword", new String[]{"word", "student"}));
    System.out.println(findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
//    System.out.println(findSubstring("aaa", new String[]{"a", "a"}));
//    System.out.println(findSubstring("aaa", new String[]{"a"}));
  }

  private static List<Integer> findSubstring(String s, String[] words) {
    if (words.length == 0) return new ArrayList<>();
    // 使用Map保存带查找的字符串
    final Map<String, Integer> counts = new HashMap<>();
    for (final String word : words) {
      counts.put(word, counts.getOrDefault(word, 0) + 1);
    }
    final List<Integer> indexes = new ArrayList<>();
    final int n = s.length(), num = words.length, len = words[0].length();
    // 0到满足的长度
    for (int i = 0; i < n - num * len + 1; i++) {
      final Map<String, Integer> seen = new HashMap<>();
      int j = 0;
      while (j < num) {
        // 双指针截取字符串
        final String word = s.substring(i + j * len, i + (j + 1) * len);
        System.out.println(word + ", " + i + ", " + j);
        if (counts.containsKey(word)) {
          // 在，存储查找个数
          seen.put(word, seen.getOrDefault(word, 0) + 1);
          // 若个数大于待查找个数，则说明不符合条件
          if (seen.get(word) > counts.getOrDefault(word, 0)) {
            break;
          }
        } else {
          // 不在，直接进入下一次循环
          break;
        }
        j++;
      }
      if (j == num) {
        indexes.add(i);
      }
    }
    return indexes;
  }
}
