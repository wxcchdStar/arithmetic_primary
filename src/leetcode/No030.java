package leetcode;

import java.util.*;

/**
 * 30.串联所有单词的子串
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
    System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    System.out.println(findSubstring("wordgoodstudentgoodword", new String[]{"word", "student"}));
    System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    System.out.println(findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
//    System.out.println(findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
//    System.out.println(findSubstring("aaa", new String[]{"a", "a"}));
//    System.out.println(findSubstring("aaa", new String[]{"a"}));
  }

  private static List<Integer> findSubstring(String s, String[] words) {
    set.clear();
    permuate(words, 0, words.length - 1);

    List<Integer> indexes = new ArrayList<>();
    int i = 0, j = 0;
    while (i <= s.length()) {
      String subStr = s.substring(j, i);
      while (containAll(subStr, false) && !containAll(subStr, true) && j < i) {
        j++;
        subStr = s.substring(j, i);
      }
      if (containAll(subStr, true)) {
        indexes.add(j);
        j++;
      }
      i++;
    }
    return indexes;
  }

  private static boolean containAll(String str, boolean stick) {
    for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
      String item = iterator.next();
      if (!stick && str.contains(item)) {
        return true;
      } else if (stick && str.equals(item)) {
        return true;
      }
    }
    return false;
  }

  private static HashSet<String> set = new HashSet<>();

  private static void permuate(String[] words, int start, int end) {
    if (start == end) {
      StringBuilder str = new StringBuilder();
      for (String word : words) {
        str.append(word);
      }
      if (!set.contains(str.toString())) {
        set.add(str.toString());
      }
      return;
    }
    for (int i = 0; i < words.length; i++) {
      swap(words, start, i);
      permuate(words, start + 1, end);
      swap(words, start, i);
    }
  }

  private static void swap(String[] words, int i, int j) {
    String temp = words[i];
    words[i] = words[j];
    words[j] = temp;
  }

  private static List<Integer> findSubstring2(String s, String[] words) {
    if (words.length == 0) return new ArrayList<>();

    //HashMap1 存所有单词
    HashMap<String, Integer> allWords = new HashMap<>(words.length);
    for (String w : words) {
      int value = allWords.getOrDefault(w, 0);
      allWords.put(w, value + 1);
    }

    int wordLen = words[0].length();

    List<Integer> indexes = new ArrayList<>();

    for (int i = 0; i < s.length() - words.length * wordLen + 1; i++) {
      //HashMap2 存当前扫描的字符串含有的单词
      HashMap<String, Integer> hasWords = new HashMap<>();
      int num = 0;
      //判断该子串是否符合
      while (num < words.length) {
        String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
        //判断该单词在 HashMap1 中
        if (allWords.containsKey(word)) {
          int value = hasWords.getOrDefault(word, 0);
          hasWords.put(word, value + 1);
          //判断当前单词的 value 和 HashMap1 中该单词的 value
          if (hasWords.get(word) > allWords.get(word)) {
            break;
          }
          num++;
        } else {
          break;
        }
      }
      //判断是不是所有的单词都符合条件
      if (num == words.length) {
        indexes.add(i);
      }
    }

    return indexes;
  }

}
