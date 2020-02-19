package leetcode;

/**
 * 跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class No055 {

  public static void main(String[] args) {
    System.out.println(canJump2(new int[]{2, 3, 1, 1, 4}));
    System.out.println(canJump2(new int[]{3, 2, 1, 0, 4}));
//    System.out.println(canJump2(new int[]{2, 0}));
  }

  private static boolean canJump2(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
//      System.out.println(i + "," + nums[i] + ":" + lastPos);
    }
    return lastPos == 0;
  }

  private static boolean canJump(int[] nums) {
    result = new int[nums.length];
    result[nums.length - 1] = 1;
    return test(nums, 0);
  }

  static int[] result;

  private static boolean test(int[] nums, int start) {
    if (result[start] != 0) {
      return result[start] == 1;
    }
    for (int i = 1; start + i < nums.length && i <= nums[start]; i++) {
      if (test(nums, start + i)) {
        result[i] = 1;
        return true;
      }
    }
    result[start] = 2;
    return false;
  }

  private static boolean test2(int[] nums, int k) {
    if (k == 0) return nums.length <= 1 || nums[0] > 0;

    boolean result = false;
    for (int i = 1; i <= k; i++) {
      if (nums[k - i] >= i) {
        result |= test2(nums, k - i);
      }
    }
    return result;
  }
}
