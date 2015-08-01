package dsaa.chapter1;

/**
 * 求一个数的二进制中1的个数
 * Created by ChenHd on 2015/5/13.
 */
public class OneCount {

    public static void main(String[] args) {
        int n = 101;
        System.out.println(String.format("One count of the %d is: %d", n, oneCount(n)));
        System.out.println(Integer.toBinaryString(n));
    }

    public static int oneCount(int n) {
        if (n >= 0) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return n % 2 + oneCount(n / 2);
            }
        }
        return -1;
    }
}
