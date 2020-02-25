package somewhere;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A的顶部取一个数放到B的顶部，然后A再取一个数放到A自己的底部。
 * 已知B，求A。
 */
public class RestoreArraySorted {

  public static void main(String[] args) {
    int[] B = new int[]{0, 2, 4, 6, 1, 5, 3, 7};
    int[] A = new int[B.length];
    test2(A, B);
    System.out.println(Arrays.toString(A));
  }

  private static void test2(int[] A, int[] B) {
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < B.length; i++) {
      queue.add(i);
    }

    int[] temp = new int[B.length];
    int j = 0;
    while (true) {
      int i = queue.pollFirst();
      temp[j] = i;
      j++;
      if (queue.isEmpty()) {
        break;
      }
      queue.add(queue.pollFirst());
    }

    for (int index : temp) {
      A[temp[index]] = B[index];
    }
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
