package leetcode;

import java.util.Stack;

public class No020 {

  public static void main(String[] args) {
    System.out.println(isValid("}"));
  }

  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }
        Character cha = stack.pop();
        if (cha == '(' && c != ')') return false;
        if (cha == '[' && c != ']') return false;
        if (cha == '{' && c != '}') return false;
      }
    }

    return stack.empty();
  }
}
