package leetcode;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No043 {

  public static void main(String[] args) {
    System.out.println(new No043().multiply("5", "3"));
  }

  public String multiply(String num1, String num2) {
    int[] res = new int[num1.length() + num2.length()];

    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
//        System.out.println(num1.charAt(i) + "x" + num2.charAt(j));
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = mul + res[i + j + 1];
        res[i + j + 1] = sum % 10;
        res[i + j] += sum / 10;
      }
    }
//    System.out.println(Arrays.toString(res));

    String str = "";
    boolean start = false;
    for (int n : res) {
      if (n != 0 && !start) {
        start = true;
      }
      if (start) {
        str = str + n;
      }
    }
    return str.length() == 0 ? "0" : str;
  }
}
