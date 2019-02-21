package basic;

import java.util.Arrays;

/**
 * @author chenhd
 */
public class Permutation {

  public static void main(String[] args) {
    char[] array = "123".toCharArray();
    permutation(array, 0, array.length - 1);
  }

  private static void permutation(char[] array, int start, int end) {
    if (start == end) {
      System.out.println(Arrays.toString(array));
      return;
    }

    for(int i = start; i <= end; i++) {
      swap(array, start, i);
      permutation(array, start + 1, end);
      swap(array, start, i);
    }
  }

  private static void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
