package basic;

import java.util.Arrays;

/**
 * 各种排序
 *
 * Created by ChenHd on 2015/5/13.
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 21, 1, 5, 8, 9, 10, 2 };
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(bubbleSort(arr.clone(), true)));
        System.out.println(Arrays.toString(bubbleSort(arr.clone(), false)));

        System.out.println("Insert Sort:");
        System.out.println(Arrays.toString(insertSort(arr.clone(), true)));
        System.out.println(Arrays.toString(insertSort(arr.clone(), false)));

        System.out.println("Merge Sort:");
        int[] arrTemp = arr.clone();
        mergeSort(arrTemp, 0, arrTemp.length - 1);
        System.out.println(Arrays.toString(arrTemp));

        System.out.println("Heap Sort:");
        arrTemp = arr.clone();
        heapSort(arrTemp);
        System.out.println(Arrays.toString(arrTemp));

        System.out.println("Quick Sort:");
        arrTemp = arr.clone();
        quickSort(arrTemp, 0, arrTemp.length - 1);
        System.out.println(Arrays.toString(arrTemp));

        System.out.println("Count Sort:");
        arrTemp = arr.clone();
        countSort(arrTemp);
    }

    /**
     * 冒泡排序
     * @param arr
     * @param increase true为按递增排序，false为按递减排序
     * @return
     */
    public static int[] bubbleSort(int[] arr, boolean increase) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (increase) {
                        if (arr[i] > arr[j]) {
                            arr[i] ^= arr[j];
                            arr[j] ^= arr[i];
                            arr[i] ^= arr[j];
                        }
                    } else {
                        if (arr[i] < arr[j]) {
                            arr[i] ^= arr[j];
                            arr[j] ^= arr[i];
                            arr[i] ^= arr[j];
                        }
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @param increase
     * @return
     */
    public static int[] insertSort(int[] arr, boolean increase) {
        if (arr != null && arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                int k = i;
                if (increase) {
                    while (k > 0 && arr[k] < arr[k - 1]) {
                        arr[k] ^= arr[k - 1];
                        arr[k - 1] ^= arr[k];
                        arr[k] ^= arr[k - 1];
                        k--;
                    }
                } else {
                    while (k > 0 && arr[k] > arr[k - 1]) {
                        arr[k] ^= arr[k - 1];
                        arr[k - 1] ^= arr[k];
                        arr[k] ^= arr[k - 1];
                        k--;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 合并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] arr1 = new int[middle - left + 1];
        for (int i = left; i <= middle; i++) {
            arr1[i - left] = arr[i];
        }

        int[] arr2 = new int[right - middle];
        for (int i = middle + 1; i <= right; i++) {
            arr2[i - middle - 1] = arr[i];
        }

        int indexOfArr = left;
        int indexOfArr1 = 0;
        int indexOfArr2 = 0;
        while (indexOfArr1 < arr1.length && indexOfArr2 < arr2.length) {
            if (arr1[indexOfArr1] < arr2[indexOfArr2]) {
                arr[indexOfArr] = arr1[indexOfArr1];
                indexOfArr1++;
            } else {
                arr[indexOfArr] = arr2[indexOfArr2];
                indexOfArr2++;
            }
            indexOfArr++;
        }

        while (indexOfArr1 < arr1.length) {
            arr[indexOfArr] = arr1[indexOfArr1];
            indexOfArr++;
            indexOfArr1++;
        }

        while (indexOfArr2 < arr2.length) {
            arr[indexOfArr] = arr2[indexOfArr2];
            indexOfArr++;
            indexOfArr2++;
        }
    }

    /**
     * 堆是一个完全二叉树，最大堆：根节点大于等于子节点，最小堆：根节点小于等于子节点。
     * 根节点是i，那么左子节点是2i-1，右子节点是2i，父节点是i/2。
     * @param arr
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeap(arr, i, arr.length);
        }
        int heapSize = arr.length;
        while (heapSize > 1) {
            arr[0] ^= arr[heapSize - 1];
            arr[heapSize - 1] ^= arr[0];
            arr[0] ^= arr[heapSize - 1];
            heapSize--;
            maxHeap(arr, 0, heapSize);
        }
    }

    private static void maxHeap(int[] arr, int i, int length) {
        if (i < length) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest;
            if (left < length && arr[i] < arr[left]) {
                largest = left;
            } else {
                largest = i;
            }
            if (right < length && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                arr[largest] ^= arr[i];
                arr[i] ^= arr[largest];
                arr[largest] ^= arr[i];
                maxHeap(arr, largest, length);
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param end
     */
    public static void quickSort(int[] arr, int left, int end) {
        if (left < end) {
            int partition = partition(arr, left, end);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    // [left, right)
    private static int partition(int[] arr, int left, int right) {
        int i = left - 1;
        int j = left;
        int temp = arr[right];
        while (j < right) {
            if (arr[j] < temp) {
                i++;
                if (i != j) {
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
            j++;
        }
        if (i != right) {
            i++;
            arr[i] ^= arr[right];
            arr[right] ^= arr[i];
            arr[i] ^= arr[right];
        }
        System.out.println(Arrays.toString(arr));
        return i;
    }

    /**
     * 计数排序
     * @param arr
     */
    public static void countSort(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        int[] B = new int[arr.length];

        int[] C = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            C[i] = 0;
        }

        for(int i = 0; i < arr.length; i++) {
            C[arr[i]] = C[arr[i]] + 1;
        }

        for(int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for(int i = 0; i < arr.length; i++) {
            B[C[arr[i]] - 1] = arr[i];
            C[arr[i]] = C[arr[i]] - 1;
        }

        System.out.println(Arrays.toString(B));
    }
}
