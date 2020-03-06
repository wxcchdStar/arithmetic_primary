package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author chenhd
 */
public class No001 {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 2, 4};
    System.out.println(solution1(arr, 6));
    System.out.println(solution2(arr, 6));
  }

  // 暴力解法：两两比较
  private static int[] solution1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  // 哈希表解法
  private static int[] solution2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      }
      map.put(target - nums[i], i);
    }

    throw new IllegalArgumentException("No two sum solution");
  }

  // 双指针解法，但会破坏索引
  private static int[] solution3(int[] nums, int target) {
    Arrays.sort(nums);

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum > target) {
        right--;
      } else if (sum < target) {
        left++;
      } else {
        return new int[]{left, right};
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }
}
