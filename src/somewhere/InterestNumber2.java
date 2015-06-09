package somewhere;

import java.util.ArrayList;

/**
 * 1 2 3 4 5 6 7 8 9 = 100
 * 在数据中间添加+，-，''，使得表达式等于100
 * 所有可能解
 */
public class InterestNumber2 {

    private static int TARGET_SUM = 100;
    private static int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static ArrayList<String> add(int digit, String sign, ArrayList<String> branches) {
        for (int i = 0; i < branches.size(); i++) {
            branches.set(i, digit + sign + branches.get(i));
        }

        return branches;
    }

    static ArrayList<String> f(int sum, int number, int index) {
        int digit = Math.abs(number % 10);
        if (index >= VALUES.length) {
            if (sum == number) {
                ArrayList result = new ArrayList();
                result.add(Integer.toString(digit));
                return result;
            } else {
                return new ArrayList();
            }
        }

        ArrayList branch1 = f(sum - number, VALUES[index], index + 1);
        ArrayList branch2 = f(sum - number, -VALUES[index], index + 1);

        int concatenatedNumber = number >= 0
                ? 10 * number + VALUES[index]
                : 10 * number - VALUES[index];
        ArrayList branch3 = f(sum, concatenatedNumber, index + 1);

        ArrayList results = new ArrayList();

        results.addAll(add(digit, "+", branch1));
        results.addAll(add(digit, "-", branch2));
        results.addAll(add(digit, "", branch3));

        return results;
    }

    public static void main(String[] args) {
        for (String string : f(TARGET_SUM, VALUES[0], 1)) {
            System.out.println(string);
        }
    }
}
