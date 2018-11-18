package basic;

/**
 * @author chenhd
 */
public class Combination {

  public static void main(String[] args) {
    String str = "abc";
    combination(str.toCharArray());
  }

  private static void combination(char[] array) {
    for (int i = 1; i < (1 << array.length); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < array.length; j++) {
        if ((i & (1 << j)) != 0) {
          sb.append(array[j]);
        }
      }
      System.out.println(sb.toString());
    }
  }
}
