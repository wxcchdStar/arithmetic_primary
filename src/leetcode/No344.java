package leetcode;

/**
 * 344. 反转字符串
 */
public class No344 {

  public static void main(String[] args) {
    char[] chars = "hello".toCharArray();
    new No344().reverseString(chars);
    System.out.println(chars);
  }

  public void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;
    while (i < j) {
      if (s[i] != s[j]) {
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
      }
      i++;
      j--;
    }
  }

}
