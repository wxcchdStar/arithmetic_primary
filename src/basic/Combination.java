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
    // 第一层循环，以位图的形式列出所有可能，001、010、011、100、101、110、111
    // 第二层循环，判断对应元素是否属于这种情况。0代表没有、1代表有。
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
