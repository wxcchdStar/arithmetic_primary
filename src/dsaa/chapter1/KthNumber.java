package dsaa.chapter1;

import java.util.Arrays;

/**
 * 求一个无序数组的第K个最大数
 * <p>
 * Created by ChenHd on 2015/5/13.
 */
public class KthNumber {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 2, 1, 5, 6, 4};
    System.out.println("getKthNumberBySort:");
    System.out.println(String.format("The %d\'th number is %s", 3, getKthNumberBySort(arr.clone(), 3)));
    System.out.println("getKthNumber2:");
    System.out.println(String.format("The %d\'th number is %s", 3, getKthNumber2(arr.clone(), 3)));
    System.out.println("QuickSelect:");
//        System.out.println(String.format("The %d\'th number is %s", 3, ));
    firstKMaxValue(arr.clone(), 0, arr.length - 1, 2);
  }

  /**
   * 1.先将数组递减排序，然后数组中下标为‘k-1’的数即为第k个最大数
   *
   * @param arr
   * @param k
   * @return
   */
  public static int getKthNumberBySort(int[] arr, int k) {
    int result = 0;
    if (arr != null && arr.length > 0 && arr.length >= k) {
      Arrays.sort(arr);
      return arr[arr.length - k];
    }
    return result;
  }

  /**
   * 2.先将前k个数按递减进行排序，然后将剩下的数在逐个读入，
   * 当新数小于数组中第k个数时则忽略，否则将其放到数组中正确的位置上，同时将数组中的一个元素挤出数组。
   * 当算法终止时，位于第k个位置上的元素即是第k个最大数
   *
   * @param arr
   * @param k
   * @return
   */
  public static Integer getKthNumber2(int[] arr, int k) {
    Integer result = null;
    if (arr != null && arr.length > 0 && arr.length >= k && k >= 1) {
      Arrays.sort(arr, 0, k);
      for (int i = k; i < arr.length; i++) {
        int t = arr[i];
        for (int j = k - 1; j >= 0; j--) {
          if (t > arr[j]) {
            arr[j] ^= t;
            t ^= arr[j];
            arr[j] ^= t;
          }
        }
      }
      result = arr[0];
    }
    return result;
  }

  /**
   * 使用快速选择地方式快速去除第k个最大数
   *
   * @param array
   * @param start
   * @param end
   * @param k
   */
  public static int firstKMaxValue(int[] array, int start, int end, int k) {
    if (start > end) { // 限制条件
      return -1;
    }
    // 索引为start的值作为分区值
    int div = array[start];
    int j = start; // X
    // 以下循环将数组分为两部分,左边部分大于分区值,右边部分小于等于分区值
    // 先将start-end的数组分好，最后将array[start]放在中间
    for (int i = start + 1; i <= end; i++) {
      if (array[i] > div) {
        j++;
        if (j != i) {
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
    }
    array[start] = array[j];
    array[j] = div;

    System.out.println(Arrays.toString(array));

    // 此时分区值处于它在数组中对应的位置上，如分区值是数组中的第2个元素，那么j就应该等于1。
    // 如果j<k，就以array[j+1]作为分区值，重新划分右部分数组
    // 如果j>k，就以array[start]作为分区值，重新划分左部分数组。
    //      注意这里的array[start]与原始数组的array[start]的值可能是不同的。
    // 如果j=k，就计算出了数组中第K（k>=0）个最大数的值。
    if (j < k) {
      return firstKMaxValue(array, j + 1, end, k);
    } else if (j > k) {
      return firstKMaxValue(array, start, j - 1, k);
    } else {
      System.out.println(j + "," + k + "," + array[j]);
      return array[j];
    }
  }

}