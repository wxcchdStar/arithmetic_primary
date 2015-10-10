package dsaa.chapter1;

/**
 * 输出一个字符串的字符的所有排列组合
 * Created by ChenHd on 2015/5/13.
 */
public class Permute {

    public static void main(String[] args) {
        String str = "abc";
        permute(str);
        System.out.println("-------------------------");
        combination(str.toCharArray());
        System.out.println("-------------------------");
        combination2(str.toCharArray());
    }

    public static void permute(String str) {
        char[] chars = str.toCharArray();
        permute(chars, 0, chars.length);
    }

    /**
     * 基于递归
     * @param str
     * @param low
     * @param high
     */
    public static void permute(char[] str, int low, int high) {
        if (low == high) {
            System.out.println(String.valueOf(str) + "|");
            return;
        }
        for (int i = low; i < high; i++) {
            if (isSwap(str, low, i)) {
                // 此处不能用ab-ba-ab是因为a和b可能指向同一个变量，ab转换后就为0了
                char temp = str[low];
                str[low] = str[i];
                str[i] = temp;

                permute(str, low + 1, high);

                temp = str[low];
                str[low] = str[i];
                str[i] = temp;
            }
        }
    }

    private static boolean isSwap(char[] str, int low, int high) {
        for (; low < high; low++) {
            if (str[low] == str[high]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 基于位图，000，100...
     * @param str
     */
    public static void combination(char[] str) {
        int count = 1 << str.length;
        for (int i = 1; i < count; i++) {
            boolean b = false;
            for (int j = 0; j < str.length; j++) {
                if ((i & (1 << j)) == 0) {
                    b = true;
                    System.out.print(str[j]);
                }
            }
            if (b) System.out.println();
        }
    }

    /**
     * 基于位图，000，100...
     * @param str
     */
    public static void combination2(char[] str) {
        int count = 1 << str.length;
        for (int i = 1; i < count; i++) {
            int p = i;
            for (int j = 0; j < str.length; j++) {
                int s = p % 2;
                p = p / 2;
                if (s == 1) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
