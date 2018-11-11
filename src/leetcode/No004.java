package leetcode;

/**
 * 两个排序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * @author chenhd
 */
public class No004 {

  public static void main(String[] args) {
    int[] nums1 = new int[]{};
    int[] nums2 = new int[]{1};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length + nums2.length];
    int i = 0, j = 0, k = 0;
    while (i < nums1.length || j < nums2.length) {
      if (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
          result[k++] = nums1[i++];
        } else {
          result[k++] = nums2[j++];
        }
      } else if (i < nums1.length) {
        result[k++] = nums1[i++];
      } else if (j < nums2.length) {
        result[k++] = nums2[j++];
      }
    }
    int mid = result.length / 2;
    if (result.length % 2 == 0) {
      return (result[mid - 1] + result[mid]) / 2.0;
    } else {
      return result[mid];
    }
  }
}