package leetcode;

/**
 * 69. x 的平方根
 */
public class No69 {

  public static void main(String[] args) {
    System.out.println(new No69().mySqrt(2147483647));
  }

  public int mySqrt(int x) {
    if (x == 0) return 0;

    int left = 1, right = x / 2;
    int mid = 1;
    while (left <= right) {
      mid = (right + left) / 2;
      long temp = 1L * mid * mid;
      if (temp == x) {
        return mid;
      } else if (temp > x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
//      System.out.println(left + "\t" + right + ":\t" + mid);
    }

    return 1L * mid * mid > x ? mid - 1 : mid;
  }
}
