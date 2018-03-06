package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhd
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 2, 4};
    System.out.println(solution1(arr, 6));
    System.out.println(solution2(arr, 6));
  }

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
}
