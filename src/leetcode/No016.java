package leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author chenhd
 */
public class No016 {

  public static void main(String[] args) {
//    int[] nums = {-1, 2, 1, -4};
    int[] nums = {-3, -2, -5, 3, -4};
    System.out.println(threeSumClosest(nums, -1));
  }

  private static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    boolean hasResult = false;
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];

      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int towSum = nums[left] + nums[right];
        if (towSum == temp) {
          return target;
        } else if (towSum > temp) {
          right--;
        } else {
          left++;
        }
        if (!hasResult || Math.abs(target - towSum - nums[i]) < Math.abs(target - result)) {
          hasResult = true;
          result = towSum + nums[i];
        }
      }
    }

    return result;
  }
}
