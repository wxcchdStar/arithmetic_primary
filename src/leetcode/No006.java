package leetcode;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * <p>
 * 实现一个将字符串进行指定行数变换的函数:
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * <p>
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author chenhd
 */
public class No006 {

  public static void main(String[] args) {
    System.out.println(convert("tgflhuqldooiqjxqfvinjcksgqeguglnosavorgrhxcaizsnwabfcnalfgrzmepaypxniegsdisljkzhkc", 32));
  }

  public static String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    StringBuilder result = new StringBuilder("");

    int space = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      for (int j = i; j < s.length(); j += space) {
        result.append(s.charAt(j));
        int index = j + 2 * (numRows - i) - 2;
        if (index > 0 && index < s.length() && index < j + space && index != j) {
          result.append(s.charAt(index));
        }
      }
    }

    return result.toString();
  }
}
