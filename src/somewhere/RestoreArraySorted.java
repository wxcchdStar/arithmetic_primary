package somewhere;

import java.util.Arrays;

/**
 * A的顶部取一个数放到B的顶部，然后A再取一个数放到A自己的底部。
 * 已知B，求A。
 */
public class RestoreArraySorted {

  public static void main(String[] args) {
    int[] B = new int[]{1, 3, 5, 7, 2, 6, 4, 8};
    int[] A = new int[B.length];
    test(A, B);
    System.out.println(Arrays.toString(A));
  }

  private static void test(int[] A, int[] B) {
    int i = 0;
    int j = 0;

    int fillCount = 0;
    while (fillCount < A.length) {
      A[i] = B[j];
      j++;

      fillCount++;
      if (fillCount == A.length) {
        return;
      }

      int step = 0;
      while (step < 2) {
        i += 1;
        if (i >= A.length) {
          i = 0;
        }
        if (A[i] == 0) {
          step++;
        }
      }
    }
  }
}
