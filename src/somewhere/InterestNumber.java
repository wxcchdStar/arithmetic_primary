package somewhere;

import java.util.ArrayList;
import java.util.List;

/**
 * 1 2 3 4 5 6 7 8 9 = 110
 */
public class InterestNumber {

    public static void compute() {
        for (int i = 0; i < (int) Math.pow(3, 8); i++) {
            String[] a = new String[17];
            for (int n = 0; n < 9; n++) {
                a[2 * n] = (n + 1) + "";
            }
            int p = i;
            for (int j = 0; j < 8; j++) {
                int s = p % 3;
                p = p / 3;
                switch (s) {
                    case 0:
                        a[2 * j + 1] = "+";
                        break;
                    case 1:
                        a[2 * j + 1] = "-";
                        break;
                    case 2:
                        a[2 * j + 1] = " ";
                        break;
                }
            }
            if (compute2(change(a)) == 110L) {
                System.out.println(change(a));
            }
        }
    }

    private static String change(String[] s) {
        StringBuffer sb = new StringBuffer();
        for (String ss : s) {
            if (!ss.equals(" ")) {
                sb.append(ss);
            }
        }
        return sb.toString();
    }

    private static long compute2(String s) {
        long sum = 0;
        String[] array = s.trim().split("[+-]");
        String[] array2 = s.trim().split("\\d+");

        List<Long> l = new ArrayList<Long>();
        int j = 0;
        for (int i = 1; i < array2.length; i++) {
            char c = array2[i].charAt(0);
            while (l.size() != 2) {
                l.add(Long.parseLong(array[j++]));
            }
            switch (c) {
                case '-':
                    sum = l.get(0) - l.get(1);
                    break;
                case '+':
                    sum = l.get(0) + l.get(1);
                    break;
            }
            l.set(0, sum);
            l.remove(1);
        }
        if (l.size() != 0) {
            sum = l.get(0);
        } else {
            sum = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        compute();
    }

}
