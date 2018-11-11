package leetcode;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 * @author chenhd
 */
public class No007 {

  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(reverse(-123));
  }

  private static int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int pop = x % 10;
      x = x / 10;

      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop == 7)) {
        return 0;
      } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop == -8)) {
        return 0;
      }
      result = result * 10 + pop;
    }
    return result;
  }

}
