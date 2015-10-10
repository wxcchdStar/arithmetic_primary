package dsaa.chapter2;

/**
 * Created by chenhd on 15/9/28.
 */
public class Pow {

    public static void main(String[] args) {
        for (int i = 0; i < 63; i ++) {
            boolean isEqual = Math.pow(2, i) == pow(2, i);
            if (!isEqual) {
                System.out.println(i + ": " + Math.pow(2, i) + ", " + pow(2, i));
            }
        }
    }

    /**
     * n为偶数, 则x^n=x^(n/2)*x^(n/2)=(x*x)^(n/2);
     * n为奇数, 则x^n=x^(n/2)*x^(n/2)*x=(x*x)^(n/2)*x;
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }
}
