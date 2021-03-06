package basic;

import java.util.Arrays;

/**
 * 常用排序算法
 * <p>
 * Created by ChenHd on 2015/5/13.
 */
public class Sort {

  public static void main(String[] args) {
    int[] arr = new int[]{8, 21, 1, 5, 8, 9, 10, 2};
    System.out.println("Bubble Sort:");
    System.out.println(Arrays.toString(bubbleSort(arr.clone())));

    System.out.println("Selection Sort:");
    int[] arrTemp = arr.clone();
    selectionSort(arrTemp);

    System.out.println("Insert Sort:");
    System.out.println(Arrays.toString(insertSort(arr.clone())));

    System.out.println("Merge Sort:");
    arrTemp = arr.clone();
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

    System.out.println("Shell Sort:");
    arrTemp = arr.clone();
    shellSort(arrTemp);
  }

  /**
   * 冒泡排序
   *
   * @param arr
   * @return
   */
  public static int[] bubbleSort(int[] arr) {
    if (arr != null && arr.length > 1) {
      // 两两之间交换位置
      for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[i] > arr[j]) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
          }
        }
      }
    }
    return arr;
  }

  /**
   * 选择排序
   *
   * @param arr
   */
  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      // 在找右侧的最小值，与左侧的元素交换位置
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      if (arr[i] != arr[min]) {
        arr[i] ^= arr[min];
        arr[min] ^= arr[i];
        arr[i] ^= arr[min];
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * 插入排序
   *
   * @param arr
   * @return
   */
  public static int[] insertSort(int[] arr) {
    if (arr != null && arr.length > 1) {
      for (int i = 1; i < arr.length; i++) {
        // 将右侧元素有序地插入到左侧
        int k = i;
        while (k > 0 && arr[k] < arr[k - 1]) {
          arr[k] ^= arr[k - 1];
          arr[k - 1] ^= arr[k];
          arr[k] ^= arr[k - 1];
          k--;
        }
      }
    }
    return arr;
  }

  /**
   * 合并排序
   *
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

  // 将两个有序数组合并成一个有序数组
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
   * 堆排序
   *
   * parent(i) { return i / 2 }
   * left(i) { return 2i }
   * right(i) { return 2i + 1 }
   *
   * @param arr
   */
  public static void heapSort(int[] arr) {
    // 建堆
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      maxHeap(arr, i, arr.length);
    }
    // 排序，一个一个地将最大的放在数组末尾
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
      // 找出此节点、左子节点、右子节点当中最大值的索引
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
        // 交换最大值与该节点的值
        arr[largest] ^= arr[i];
        arr[i] ^= arr[largest];
        arr[largest] ^= arr[i];
        maxHeap(arr, largest, length);
      }
    }
  }

  /**
   * 快速排序
   *
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

  // 使用双指针，将左右两侧的元素分别于第一个元素进行比较，将数组分成两部分
  // 左部分小于第一个元素，右部分大于等于第一个元素，并返回索引
  private static int partition(int[] arr, int left, int right) {
    int temp = arr[left];
    int i = left;
    int j = right;
    while (i < j) {
      while (arr[j] > temp && i < j) {
        j--;
      }
      while (arr[i] <= temp && i < j) {
        i++;
      }
      if (i < j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
      }
    }
    arr[left] = arr[i];
    arr[i] = temp;
    return i;
  }

  /**
   * 计数排序
   *
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

    for (int i = 0; i < arr.length; i++) {
      C[arr[i]] = C[arr[i]] + 1;
    }

    for (int i = 1; i < C.length; i++) {
      C[i] = C[i] + C[i - 1];
    }

    for (int i = 0; i < arr.length; i++) {
      B[C[arr[i]] - 1] = arr[i];
      C[arr[i]] = C[arr[i]] - 1;
    }

    System.out.println(Arrays.toString(B));
  }

  /**
   * 希尔排序
   * <p>
   * 是数组中任意间隔为h的元素是有序的
   *
   * @param arr
   */
  public static void shellSort(int[] arr) {
    int h = 1;
    while (h < arr.length / 3) {
      h += h * 3 + 1;
    }
    while (h >= 1) {
      insertSort(arr);
      h /= 3;
    }
    System.out.println(Arrays.toString(arr));
  }

}
