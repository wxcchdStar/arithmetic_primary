package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最长有效括号
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class No032 {

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(()"));
    System.out.println(longestValidParentheses(")()())"));
    System.out.println(longestValidParentheses("()(()"));
    System.out.println(longestValidParentheses("()(())"));
    System.out.println(longestValidParentheses("())"));
    System.out.println(longestValidParentheses("(()())"));
  }

  private static int longestValidParentheses2(String s) {
    int result = 0;
    char[] array = s.toCharArray();
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (i == 0) {
        dp[0] = 0;
      } else if (i == 1) {
        dp[1] = array[0] == '(' && array[1] == ')' ? 2 : 0;
      } else {
        if (array[i] == ')' && array[i - 1] == '(') {
          dp[i] = dp[i - 2] + 2;
        } else if (array[i] == ')' && array[i - 1] == ')' && i - dp[i - 1] - 1 >= 0 && array[i - dp[i - 1] - 1] == '(') {
          dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
        }
      }
      result = Math.max(result, dp[i]);
    }
    return result;
  }

  private static int longestValidParentheses(String s) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          result = Math.max(result, i - stack.peek());
        }
      }
    }
    return result;
  }
}
