package dsaa.chapter2;

/**
 * Created by chenhd on 15/9/28.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) return -1;

        int mid = (end + start) / 2;
        if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, end, target);
        } else {
            return mid;
        }
    }
}
