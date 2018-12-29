package somewhere;

import java.util.Arrays;

public class TwoPeopleCountNumber {

  private static int MAX = 10;
  private static int[] fi = new int[20];
  private static boolean[] visited = new boolean[MAX + 1];
  private static int[] sg = new int[MAX + 1];

  private static String solution(String line) {
    String[] values = line.split(" ");
    int left = Integer.parseInt(values[0]);
    int right = Integer.parseInt(values[1]);
    getValues();
    getAnswer();
    if ((sg[left] ^ sg[right]) == 0) {
      return "B Win";
    } else {
      return "A Win";
    }
  }

  private static void getValues() {
    fi[0] = 1;
    fi[1] = 2;
    for (int i = 2; ; i++) {
      fi[i] = fi[i - 1] + fi[i - 2];
      if (fi[i] > MAX) {
        break;
      }
    }
  }

  private static void getAnswer() {
    for (int i = 1; i <= MAX; i++) {
      Arrays.fill(visited, false);
      for (int j = 0; fi[j] <= MAX && fi[j] <= i; j++) {
        visited[sg[i - fi[j]]] = true;
      }
      for (int j = 0; j <= MAX; j++) {
        if (!visited[j]) {
          sg[i] = j;
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    String line = "1 4";
    System.out.println(solution(line));
  }
}
