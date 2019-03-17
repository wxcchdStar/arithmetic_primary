package leetcode;

/**
 * 爬楼梯
 */
public class No070 {

  public static void main(String[] args) {

  }

  private static int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int a = 1;
    int b = 2;
    int c = 0;
    for (int i = 3; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}
