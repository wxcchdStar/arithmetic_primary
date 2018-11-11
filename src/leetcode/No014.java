package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author chenhd
 */
public class No014 {

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    System.out.println(longestCommonPrefix(new String[]{"aca","cba"}));
  }

  // 找出最短字符串，比较每个字符直到不相等或遍历完
  private static String longestCommonPrefix(String[] strs) {
    int minLength = Integer.MAX_VALUE;
    for (String str : strs) {
      if (str.length() < minLength) {
        minLength = str.length();
      }
    }

    String result = "";
    for (int i = 0; i < minLength; i++) {
      int j = 0;
      int n = 0;
      while(j < strs.length - 1) {
        if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
          n++;
        }
        j++;
      }
      if (n == strs.length - 1) {
        result += strs[0].charAt(i);
      } else {
        return result;
      }
    }
    return result;
  }

}
