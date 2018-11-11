package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author chenhd
 */
public class No012 {

  public static void main(String[] args) {
    System.out.println(intToRoman(3));
    System.out.println(intToRoman(4));
    System.out.println(intToRoman(9));
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(1994));
    System.out.println(intToRoman(61));
    System.out.println(intToRoman(64));
  }

  static Map<Integer, String> map = new HashMap<>(13);

  static {
    map.put(1, "I");
    map.put(5, "V");
    map.put(10, "X");
    map.put(50, "L");
    map.put(100, "C");
    map.put(500, "D");
    map.put(1000, "M");
    map.put(4, "IV");
    map.put(9, "IX");
    map.put(40, "XL");
    map.put(90, "XC");
    map.put(400, "CD");
    map.put(900, "CM");
  }

  private static String intToRoman(int num) {
    String result = "";
    int bit = 0;
    while (num > 0) {
      int tmp = num % 10;
      num /= 10;
      if (tmp < 4) {
        while (tmp > 0) {
          result = map.get(pow(1, bit)) + result;
          tmp--;
        }
      } else if (tmp == 4) {
        result = map.get(pow(4, bit)) + result;
      } else if (tmp == 5) {
        result = map.get(pow(5, bit)) + result;
      } else if (tmp < 9) {
        String tmpStr = map.get(pow(5, bit));
        tmp = tmp - 5;
        while (tmp > 0) {
          tmpStr += map.get(pow(1, bit));
          tmp--;
        }
        result = tmpStr + result;
      } else if (tmp == 9) {
        result = map.get(pow(9, bit)) + result;
      }
      bit++;
    }

    return result;
  }

  private static int pow(int n, int bit) {
    if (bit == 0) {
      return n;
    }
    return n * (int) Math.pow(10, bit);
  }
}
