package somewhere;

import java.util.Arrays;

public class ThreeNumber {

  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{8, 9, 8, 8}, 4));
    for (int i = 0; i < 5; i++) {
      System.out.println((3 >> i) & 1);
    }
  }

  private static int singleNumber(int[] A, int n) {
    int[] count = new int[32];
    Arrays.fill(count, 0);

    int result = 0;
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println(A[j] + ">>>" + Integer.toBinaryString(A[j]));
        if (((A[j] >> i) & 1) == 1) {
          count[i]++;
        }
      }
      result |= ((count[i] % 3) << i);
      System.out.println(result + "===============" + Arrays.toString(count));
    }
    return result;
  }
}
