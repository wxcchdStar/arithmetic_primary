package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author chenhd
 */
public class No046 {

  public static void main(String[] args) {
    List<List<Integer>> lists = permute(new int[]{1, 2, 3});
    for (List<Integer> list : lists) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permusteItem(result, nums, 0, nums.length - 1);
    return result;
  }

  private static void permusteItem(List<List<Integer>> result, int[] nums, int start, int end) {
    if (start == end) {
      List<Integer> list = new ArrayList<>();
      for (int num : nums) {
        list.add(num);
      }
      result.add(list);
    }
    for (int i = start; i <= end; i++) {
      swap(nums, start, i);
      permusteItem(result, nums, start + 1, end);
      swap(nums, start, i);
    }
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
