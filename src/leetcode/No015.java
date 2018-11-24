package leetcode;

import java.util.*;

/**
 * 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author chenhd
 */
public class No015 {

  public static void main(String[] args) {
//    int[] nums = {-1, 0, 1, 2, -1, -4};
//    int[] nums = {0, 0, 0, 0, 0};
//    int[] nums = {-2, 0, 0, 2, 2};
    int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
    List<List<Integer>> lists = threeSum(nums);
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      // 将三数之和降为两数之和
      int target = 0 - nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      int lastLeft = Integer.MAX_VALUE;
      int lastRight = Integer.MAX_VALUE;
      // 双指针遍历找出两数之和的解
      while (left < right) {
        if (nums[left] + nums[right] == target) {
          if (lastLeft != nums[left] && lastRight != nums[right]) {
            lastLeft = nums[left];
            lastRight = nums[right];

            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[left]);
            list.add(nums[right]);
            result.add(list);

            if (nums[left] == nums[right]) {
              break;
            }
          }
          left++;
          right--;
        } else if (nums[left] + nums[right] > target) {
          right--;
        } else {
          left++;
        }
      }
    }
    return result;
  }

}
