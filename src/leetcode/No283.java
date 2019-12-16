package leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class No283 {

  public static void main(String[] args) {
//    int[] nums = new int[]{0, 1, 0, 3, 12};
    int[] nums = new int[]{1};
    new No283().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  public void moveZeroes(int[] nums) {
    int j = -1;
    for (int i = 0; i < nums.length; i++) {
      if (j == -1 && nums[i] == 0) {
        j = i;
      } else if (nums[i] != 0 && j != -1) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];

        while (j < i) {
          if (nums[j] == 0) {
            break;
          }
          j++;
        }
      }
    }
  }
}
