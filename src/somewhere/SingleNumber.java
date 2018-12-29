package somewhere;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  public static void main(String[] args) {
    String line = "1 1 2 2 3 4 4";
    System.out.println(solution(line));
    System.out.println(solution2(line));
  }

  private static String solution(String line) {
    String[] array = line.split(" ");

    Map<String, Integer> map = new HashMap<>();
    for (String item : array) {
      if (map.containsKey(item)) {
        map.put(item, map.get(item) + 1);
      } else {
        map.put(item, 1);
      }
    }

    for (String key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }

    return null;
  }

  private static String solution2(String line) {
    String[] array = line.split(" ");

    int result = 0;
    for (String item : array) {
      result ^= Integer.parseInt(item);
    }

    return String.valueOf(result);
  }
}
