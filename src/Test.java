import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  private static Pattern pattern = Pattern.compile("//www\\.baidu\\.com/(\\w+)/search/(\\w+)/(\\w+)(.*)");

  public static void main(String[] args) {
    String[] arr = new String[]{
        "//www.baidu.com/search/0/1/2/3",
        "//www.baidu.com/A/search/0/1/2/3",
        "//www.baidu.com/B/search/0/1/2/3",
        "//www.baidu.com/C/search/0/1/2",
        "//www.baidu.com//search/0/1/2/3",
        "//www.baidu.com/D/searchresult/0/1/2"
    };

    for (String str : arr) {
      Matcher matcher = pattern.matcher(str);
      if (matcher.matches()) {
        System.out.print(str + "\t");
        for (int i = 1; i <= matcher.groupCount(); i++) {
          System.out.print(matcher.group(i) + "\t");
        }
        System.out.println();
      }
    }
  }

}

