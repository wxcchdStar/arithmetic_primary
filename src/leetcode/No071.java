package leetcode;

import java.util.Stack;

/**
 * 71. 简化路径
 * <p>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class No071 {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/../")); // "/"
    System.out.println(simplifyPath("/home//foo/")); // "/home/foo"
    System.out.println(simplifyPath("/a/./b/../../c/")); // "/c"
    System.out.println(simplifyPath("/a/../../b/../c//.//")); // "/c"
    System.out.println(simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
  }

  public static String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] segments = path.split("/");

    for (String segment : segments) {
      if (stack.isEmpty()) {
        if (!"".equals(segment) && !".".equals(segment) && !"..".equals(segment)) {
          stack.push(segment);
        }
      } else {
        if (".".equals(segment) || "".equals(segment)) {
          // 当前目录或重复
        } else if ("..".equals(segment)) {
          // 回到上级目录
          stack.pop();
        } else {
          stack.push(segment);
        }
      }
    }

    String result = "";
    while (!stack.isEmpty()) {
      String segment = stack.pop();
      if (!"".equals(segment)) {
        result = "/" + segment + result;
      }
    }
    if ("".equals(result)) {
      result = "/";
    }
    return result;
  }
}
