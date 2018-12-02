package leetcode;

import java.util.*;

/**
 * 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author chenhd
 */
public class No017 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(letterCombinations("234").toArray()));
  }

  private static Map<Character, char[]> map = new HashMap<>();

  static {
    map.put('2', new char[]{'a', 'b', 'c'});
    map.put('3', new char[]{'d', 'e', 'f'});
    map.put('4', new char[]{'g', 'h', 'i'});
    map.put('5', new char[]{'j', 'k', 'l'});
    map.put('6', new char[]{'m', 'n', 'o'});
    map.put('7', new char[]{'p', 'q', 'r', 's'});
    map.put('8', new char[]{'t', 'u', 'v'});
    map.put('9', new char[]{'w', 'x', 'y', 'z'});
  }

  private static List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    List<String> result = test(null, map.get(digits.charAt(0)));
    for (int i = 1; i < digits.length(); i++) {
      result = test2(result, map.get(digits.charAt(i)));
    }
    return result;
  }

  private static List<String> test(Character str, char[] chars) {
    String s = str != null ? String.valueOf(str) : "";

    List<String> list = new ArrayList<>();
    for (char c : chars) {
      list.add(s + String.valueOf(c));
    }
    return list;
  }

  private static List<String> test2(List<String> list, char[] chars) {
    List<String> result = new ArrayList<>();
    for (String str : list) {
      for (char c : chars) {
        result.add(str + String.valueOf(c));
      }
    }
    return result;
  }
}
