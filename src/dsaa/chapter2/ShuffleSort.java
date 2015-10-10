package dsaa.chapter2;

import java.util.Arrays;

/**
 * Created by ChenHd on 2015/5/14.
 */
public class ShuffleSort {

    // 习题随机置换第三种算法
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < 10; i++) {
//            shuffle(arr.clone());
            shuffle2(arr.clone());
        }
    }

    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            if (i != j) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shuffle2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = (int) (Math.random() * i);// j >= 0 && j < i
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
        System.out.println(Arrays.toString(arr));
    }
}
