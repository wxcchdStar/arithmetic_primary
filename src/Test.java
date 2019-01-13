import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

public class Test {

  public static void main(String[] args) throws UnsupportedEncodingException {
    System.out.println(Arrays.toString(",".split(",", 3)));
    System.out.println(URLEncoder.encode("http://www.baidu.com? a : //", "utf-8"));
  }
}

