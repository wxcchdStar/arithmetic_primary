package leetcode;

import java.util.HashSet;

/**
 * 缺失的第一个正数
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * @author chenhd
 */
public class No041 {

  public static void main(String[] args) {
    int[] nums = {7, 8, 9, 11, 12};
    System.out.println(firstMissingPositive(nums));
  }

  private static int firstMissingPositive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num < 0) {
        continue;
      }
      set.add(num);
      if (max < num) {
        max = num;
      }
    }
    if (max == Integer.MIN_VALUE) {
      max = 1;
    }
    for (int i = 1; i <= max; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return max + 1;
  }
}
