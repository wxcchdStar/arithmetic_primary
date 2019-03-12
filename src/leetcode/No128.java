package leetcode;

import java.util.Arrays;

/**
 * 最长连续序列
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class No128 {

  public static void main(String[] args) {
//    System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    System.out.println(longestConsecutive(new int[]{0, -1}));
  }

  private static int longestConsecutive(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return nums.length;

    Arrays.sort(nums);

    int currentLen = 1;
    int result = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        if (nums[i] - nums[i - 1] == 1) {
          currentLen++;
        } else {
          result = Math.max(currentLen, result);
          currentLen = 1;
        }
      }
    }
    return Math.max(currentLen, result);
  }
}
