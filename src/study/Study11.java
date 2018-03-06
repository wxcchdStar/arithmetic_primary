package study;

import java.util.Arrays;

public class Study11 {

    public static void main(String[] args) {
        System.out.println("GCD: " + gcd(-6, 8));

        int[] arr = new int[]{1, 4, 6, 8, 9, 12};
        System.out.println("BinarySearch: " + binarySearch(arr, 0, arr.length - 1, 12)
                + ", " + Arrays.binarySearch(arr, 9));

        System.out.println("IsPrime: " + isPrime(6));

        System.out.println("Binary: " + toBinary(9) + ", " + Integer.toBinaryString(9));

        System.out.println("Square: " + square(3) + ", " + Math.sqrt(3));


        System.out.println(2 % 5);
    }

    public static int gcd(int m, int n) {
        int temp = m % n;
        if (temp == 0) {
            return n;
        }
        return gcd(n, temp);
    }

    public static int binarySearch(int[] arr, int start, int end, int k) {
        if (arr == null || start > end) return Integer.MIN_VALUE;

        int middle = (start + end) / 2;
        if (arr[middle] == k) {
            return middle;
        } else if (arr[middle] > k) {
            return binarySearch(arr, start, middle - 1, k);
        } else {
            return binarySearch(arr, middle + 1, end, k);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0) return false;
        if (n == 1 || n == 3) return true;

        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static float square(int m) {
        if (m < 0) return Float.NaN;
        if (m == 0) return 0f;

        float diff = 0.0001f;
        for (float i = 0f; i <= m / 2 + 1; i += 0.0001f) {
            if (i * i + diff >= m) {
                return i;
            }
        }
        return Float.NaN;
    }

    // Integer.toBinaryString(m)
    public static String toBinary(int m) {
        if (m < 0) return "-1";

        String s = "";
        while (m > 0) {
            s = m % 2 + s;
            m = m / 2;
        }
        return s;
    }
}
