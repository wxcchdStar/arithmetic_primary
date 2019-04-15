package leetcode;

/**
 * 计算各个位数不同的数字个数
 * <p>
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class No357 {

  public static void main(String[] args) {
    System.out.println(countNumbersWithUniqueDigits2(2));
  }

  private static int countNumbersWithUniqueDigits(int n) {
    int count = (int) Math.pow(10, n);
    for (int i = 0; i < (int) Math.pow(10, n); i++) {

    }
    return count;
  }

  private static int countNumbersWithUniqueDigits2(int n) {
    if (n == 0) return 1;
    if (n == 1) return 10;

    int count = 1;
    for (int i = 10; i > 10 - n; i--) {
      count *= (i == 10 ? 9 : i);
    }
    return count + countNumbersWithUniqueDigits2(n - 1);
  }

}
