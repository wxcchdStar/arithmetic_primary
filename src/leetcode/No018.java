package leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author chenhd
 */
public class No018 {

  public static void main(String[] args) {
//    int[] nums = {1, 0, -1, 0, -2, 2};
    int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
    List<List<Integer>> lists = fourSum(nums, 0);
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  // 思路同三数之和
  private static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      List<List<Integer>> lists = threeSum(nums, i + 1, target - nums[i]);
      if (!lists.isEmpty()) {
        for (List<Integer> list : lists) {
          list.add(nums[i]);
          list.sort((o1, o2) -> o1 - o2);
          result.add(list);
        }
      }
    }
    return result;
  }

  private static List<List<Integer>> threeSum(int[] nums, int start, int n) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = start; i < nums.length - 2; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = n - nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      int lastLeft = Integer.MAX_VALUE;
      int lastRight = Integer.MAX_VALUE;
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
