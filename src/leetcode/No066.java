package leetcode;

import java.util.Arrays;

/**
 * 66. 加一
 */
public class No066 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new No066().plusOne(new int[]{9, 9, 9, 9})));
  }

  public int[] plusOne(int[] digits) {
    int n = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + (i == digits.length - 1 ? 1 : n);
      digits[i] = sum % 10;
      n = sum / 10;
      if (n == 0) {
        break;
      }
    }
    if (n == 1) {
      int[] result = new int[digits.length + 1];
      result[0] = n;
      System.arraycopy(digits, 0, result, 1, result.length - 1);
      return result;
    }
    return digits;
  }
}
