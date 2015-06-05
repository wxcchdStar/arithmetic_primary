package dsaa.chapter2;

/**
 * Created by ChenHd on 2015/5/14.
 */
public class MaxSumOfSubSequence {

    public static void main(String[] args) {
        int[] arr = new int[] { -2, 11, -4, 13, -5, -2 };
        threeForEach(arr.clone());
        System.out.println("------------------");
        twoForEach(arr.clone());
        System.out.println("------------------");
        System.out.println(maxSumByRecursion(arr, 0, arr.length - 1));
        System.out.println("------------------");
        maxSumForLinear(arr.clone());
    }

    public static void threeForEach(int[] arr) {
        if (arr != null && arr.length > 0) {
            int start = 0;
            int end = 0;
            int maxNum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    int thisSum = 0;
                    for (int k = i; k < j; k++) {
                        thisSum += arr[k];
                    }
                    if (maxNum < thisSum) {
                        maxNum = thisSum;
                        start = i;
                        end = j;
                    }
                }
            }
            System.out.println("MaxSum:" + maxNum + ", Index:[" + start + ", " + end + ")");
        }
    }

    public static void twoForEach(int[] arr) {
        if (arr != null && arr.length > 0) {
            int start = 0;
            int end = 0;
            int maxSum = 0;
            for (int i = 0; i < arr.length; i++) {
                int thisSum = 0;
                for (int j = i; j < arr.length; j++) {
                    thisSum += arr[j];
                    if (maxSum < thisSum) {
                        maxSum = thisSum;
                        start = i;
                        end = j;
                    }
                }
            }
            System.out.println("MaxSum:" + maxSum + ", Index:[" + start + ", " + end + "]");
        }
    }

    /**
     * 最大子序列之和可能在三处出现：1.左半部分，2.右半部份，3.中间部分。
     * 算出三个部分的结果之后取最大值。
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int maxSumByRecursion(int[] arr, int left, int right) {
        if (left == right) {
            if (arr[left] > 0) {
                return arr[left];
            } else {
                return 0;
            }
        }

        int middle = (left + right) / 2;
        int maxLeftSum = maxSumByRecursion(arr, left, middle);
        int maxRightSum = maxSumByRecursion(arr, middle + 1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = middle; i >= 0; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = middle + 1; i <= right; i++) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        int maxMiddleSum = maxLeftBorderSum + maxRightBorderSum;

        return maxLeftSum > maxRightSum ?
                (maxLeftSum > maxMiddleSum ? maxLeftSum : maxMiddleSum) :
                (maxRightSum > maxMiddleSum ? maxRightSum : maxMiddleSum);
    }

    public static void maxSumForLinear(int[] arr) {
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
                end = i;
            } else if (thisSum < 0) {
                thisSum = 0;
                start = i + 1;
                end = i + 1;
            }
        }
        System.out.println("MaxSum:" + maxSum + ", Index:[" + start + ", " + end + "]");
    }
}
