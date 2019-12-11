package leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 */
public class No189 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    new No189().rotate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }

  public void rotate(int[] nums, int k) {
    if (nums.length <= 1) return;
    if (k > nums.length) {
      k = k % nums.length;
    }
    rotate(nums, 0, nums.length - 1 - k);
    rotate(nums, nums.length - k, nums.length - 1);
    rotate(nums, 0, nums.length - 1);
  }

  private static void rotate(int[] nums, int start, int end) {
    while (start < end) {
      if (nums[start] != nums[end]) {
        nums[start] ^= nums[end];
        nums[end] ^= nums[start];
        nums[start] ^= nums[end];
      }
      start++;
      end--;
    }
  }
}
