package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author chenhd
 */
public class No022 {

  public static void main(String[] args) {
    for (String str : generateParenthesis(3)) {
      System.out.println(str);
    }
  }

  private static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generate(result, "", 0, 0, n);
    return result;
  }

  private static void generate(List<String> result, String cur, int open, int clode, int max) {
    if (cur.length() == max * 2) {
      result.add(cur);
      return;
    }
    if (open < max) {
      generate(result, cur + "(", open + 1, clode, max);
    }
    if (clode < open) {
      generate(result, cur + ")", open, clode + 1, max);
    }
  }
}
