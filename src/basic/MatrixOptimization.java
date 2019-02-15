package basic;

public class MatrixOptimization {

  /**
   * 公式矩阵
   */
  private static final int[][] UNIT = {{1, 1}, {1, 0}};

  /**
   * 零矩阵
   */
  private static final int[][] ZERO = {{0, 0}, {0, 0}};

  public static void main(String[] args) {
    int n = 40;
    long start = System.currentTimeMillis();
    int[][] m = fb(n);
    int result1 = m[0][1];
    System.out.println(System.currentTimeMillis() - start);

    start = System.currentTimeMillis();
    long result2 = fabnaci(n);
    System.out.println(System.currentTimeMillis() - start);

    start = System.currentTimeMillis();
    long result3 = fabnaci2(n);
    System.out.println(System.currentTimeMillis() - start);

    System.out.println("result: " + result1 + ", " + result2 + ", " + result3);
  }

  private static long fabnaci(long n) {
    if (n <= 2) return 1;
    return fabnaci(n - 1) + fabnaci(n - 2);
  }

  private static long fabnaci2(long n) {
    if (n <= 2) return 1;
    int a = 1, b = 1, c = 0;
    for (int i = 3; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  /**
   * 利用二进制进行高效幂运算
   * 求斐波那契数列
   */
  private static int[][] fb(int n) {
    if (n == 0) {
      return ZERO;
    }
    if (n == 1) {
      return UNIT;
    }
    if (n % 2 == 0) {
      int[][] matrix = fb(n >> 1);
      return multiply(matrix, matrix);
    } else {
      int[][] matrix = fb((n - 1) >> 1);
      return multiply(multiply(matrix, matrix), UNIT);
    }
  }

  /**
   * 矩阵乘法
   */
  private static int[][] multiply(int[][] m, int[][] n) {
    /*
     * 对于斐波那契数列来说，行和列都是2，这样写更易于理解，下面也给出了标准的矩阵乘法算法，是通用的
     * 用到此算法，除非进行算法学习和研究，否则一般都是进行较大数据的斐波那契求值，所以对结果取(10e9)+7的模
     */
    int[][] r = new int[2][2];
    r[0][0] = (m[0][0] * n[0][0] + m[0][1] * n[1][0]) % 1000000007;
    r[0][1] = (m[0][0] * n[0][1] + m[0][1] * n[1][1]) % 1000000007;
    r[1][0] = (m[1][0] * n[0][0] + m[1][1] * n[1][0]) % 1000000007;
    r[1][1] = (m[1][0] * n[0][1] + m[1][1] * n[1][1]) % 1000000007;
    return r;
  }

}
