package leetcode;

import java.util.*;

/**
 * 全排列II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author chenhd
 */
public class No047 {

  public static void main(String[] args) {
    List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    permusteItem(result, set, nums, 0, nums.length - 1);
    return result;
  }

  private static void permusteItem(List<List<Integer>> result, Set<List<Integer>> set, int[] nums, int start, int end) {
    if (start == end) {
      List<Integer> list = new ArrayList<>();
      for (int num : nums) {
        list.add(num);
      }
      if (!set.contains(list)) {
        result.add(list);
        set.add(list);
      }
    }
    for (int i = start; i <= end; i++) {
      swap(nums, start, i);
      permusteItem(result, set, nums, start + 1, end);
      swap(nums, start, i);
    }
  }

  private static void swap(int[] array, int i, int j) {
    if (i != j) {
      array[i] ^= array[j];
      array[j] ^= array[i];
      array[i] ^= array[j];
    }
  }
}
