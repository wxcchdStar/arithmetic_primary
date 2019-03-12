import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

  public static void main(String[] args) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    System.out.println(dateFormat.parse("2019-03-11 20:00").getTime());
  }

}

