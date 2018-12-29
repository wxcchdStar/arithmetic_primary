package july;

public class StringReverse {

  public static void main(String[] args) {
    reverse("abcde");

    int a = 9;
    int b = 10000;
    System.out.println(min(a, b));
  }

  private static int min(int a, int b) {
    /*如果a>=b,(a-b)>>31为0，否则为-1*/
    return a & ((a - b) >> 31) | b & (~(a - b) >> 31);
  }

  private static void reverse(String str) {
    char[] array = str.toCharArray();
    int start = 0;
    int end = str.length() - 1;
    while (start < end) {
      char temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
    System.out.println(String.valueOf(array));
  }
}
