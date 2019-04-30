package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 */
public class No078 {

  public static void main(String[] args) {
    for (List<Integer> list : subsets(new int[]{1, 2, 3})) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int count = 1 << nums.length;
    for (int i = 0; i < count; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((i & (1 << j)) != 0) {
          list.add(nums[j]);
        }
      }
      result.add(list);
    }
    return result;
  }
}
