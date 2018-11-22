import java.util.Arrays;

public class Test {

  public static void main(String[] args) {
    String str = "a[-addr-]b[-addr-]c";
    System.out.println(Arrays.toString(str.split("\\[-addr-]")));
  }

}

