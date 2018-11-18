import java.util.Arrays;

public class Test {

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3};
    int i = 0, j = 1;
    array[i] ^= array[j];
    array[j] ^= array[i];
    array[i] ^= array[j];
    System.out.println(Arrays.toString(array));
  }

}

