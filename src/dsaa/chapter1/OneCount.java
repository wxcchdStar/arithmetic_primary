package dsaa.chapter1;

/**
 * 求一个数的二进制中1的个数
 * Created by ChenHd on 2015/5/13.
 */
public class OneCount {

    public static void main(String[] args) {
        int n = -217;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(String.format("OneCount1 of the %d is: %d", n, oneCount(n)));
        System.out.println(String.format("OneCount2 of the %d is: %d", n, oneCount2(n)));
        System.out.println(String.format("OneCount3 of the %d is: %d", n, oneCount3(n)));
        System.out.println(String.format("OneCount4 of the %d is: %d", n, oneCount4(n)));
    }

    public static int oneCount(int n) {
        if (n >= 0) {
            int num;
            for (num = 0; n != 0; n >>= 1) {
                num += (n & 1);
            }
            return num;
        }
        return -1;
    }

    /**
     * n &= n - 1, 能消去二进制表示中最后一位1
     *
     * @param n
     * @return
     */
    public static int oneCount2(int n) {
        int num;
        for (num = 0; n != 0; num++) {
            n &= n - 1;
        }
        return num;
    }

    public static int oneCount3(int n) {
        // 0x55555555 = 0101 0101 0101 0101 0101 0101 0101 0101
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        // 0x33333333 = 0011 0011 0011 0011 0011 0011 0011 0011
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        // 0x0f0f0f0f = 0000 1111 0000 1111 0000 1111 0000 1111
        n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
        // 0x00ff00ff = 0000 0000 1111 1111 0000 0000 1111 1111
        n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff);
        // 0x00ff00ff = 0000 0000 0000 0000 1111 1111 1111 1111
        n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff);
        return n;
    }

    public static int oneCount4(int n) {
        if (n >= 0) {
            int tmp = n - ((n >> 1) & 033333333333) - ((n >> 2) & 011111111111);
            return ((tmp + (tmp >> 3)) & 030707070707) % 63;
        }
        return -1;
    }
}
