package leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class No031 {

  public static void main(String[] args) {
//    nextPermutation(new int[]{1, 2, 3});
//    nextPermutation(new int[]{1, 1, 5});
//    nextPermutation(new int[]{3, 2, 1});
//    nextPermutation(new int[]{1, 2});
//    nextPermutation(new int[]{1, 3, 2});
//    nextPermutation(new int[]{2, 3, 1});
    nextPermutation(new int[]{2, 3, 1, 3, 3});
//    nextPermutation(new int[]{9, 5, 4, 3, 1});
  }

  private static void nextPermutation(int[] nums) {
    // 找到替换点
    int replacePoint = -1;
    for (int i = nums.length - 1; i >= 1; i--) {
      if (nums[i - 1] < nums[i]) {
        replacePoint = i - 1;
        break;
      }
    }
    // 找到被替换点
    int replacePoint2 = -1;
    if (replacePoint > -1) {
      for (int i = replacePoint + 1; i < nums.length; i++) {
        if (nums[i] > nums[replacePoint]) {
          // 找出大于替换点的最小数字，如果有重复的则取最后一个
          if (replacePoint2 < 0 || nums[replacePoint2] >= nums[i]) {
            replacePoint2 = i;
          }
        }
      }
    }

    System.out.println(replacePoint + ", " + replacePoint2);

    // 交换位置，并将替换点之后的数组元素反转
    if (replacePoint >= 0 && replacePoint2 >= 0) {
      nums[replacePoint] ^= nums[replacePoint2];
      nums[replacePoint2] ^= nums[replacePoint];
      nums[replacePoint] ^= nums[replacePoint2];
      reverseArray(nums, replacePoint + 1, nums.length - 1);
    } else {
      reverseArray(nums, 0, nums.length - 1);
    }

    System.out.println(Arrays.toString(nums));
  }

  private static void reverseArray(int[] nums, int start, int end) {
    System.out.println(">>> " + Arrays.toString(nums) + ", " + start + ", " + end);
    for (int i = 0; i <= (end - start) / 2; i++) {
      if (nums[start + i] != nums[end - i]) {
        nums[start + i] ^= nums[end - i];
        nums[end - i] ^= nums[start + i];
        nums[start + i] ^= nums[end - i];
      }
    }
  }
}
