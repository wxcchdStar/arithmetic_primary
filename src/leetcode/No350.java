package leetcode;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 */
public class No350 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new No350().intersect(
        new int[]{1,2,2,1},
        new int[]{2,2})));
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      int count = map.getOrDefault(num, 0);
      if (count > 0) {
        list.add(num);
        map.put(num, count - 1);
      }
    }

    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}
