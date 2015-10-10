package dsaa.chapter2;

/**
 * Created by chenhd on 15/9/28.
 */
public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(32, 26));
    }

    // m > n
    public static int gcd(int m, int n) {
        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }
}
