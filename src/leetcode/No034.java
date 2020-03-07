package leetcode;

import java.util.Arrays;

public class No034 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
  }

  public static int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};

    int left = 0;
    int right = nums.length - 1;
    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        index = mid;
        break;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    if (index > -1) {
      for (int i = index; i >= 0; i--) {
        if (nums[i] == target) {
          result[0] = i;
        } else {
          break;
        }
      }

      for (int i = index; i < nums.length; i++) {
        if (nums[i] == target) {
          result[1] = i;
        } else {
          break;
        }
      }
    }

    return result;
  }
}
