package leetcode;

import java.util.LinkedList;

/**
 * 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class No045 {

  public static void main(String[] args) {
//    System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
//    System.out.println(jump(new int[]{2, 1}));
//    System.out.println(jump(new int[]{1, 3, 2}));
//    System.out.println(jump(new int[]{2, 3, 1}));
  }

  private static int jump(int[] nums) {
    int jumps = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      curFarthest = Math.max(curFarthest, i + nums[i]);
      if (i == curEnd) {
        jumps++;
        curEnd = curFarthest;
      }
    }
    return jumps;
  }

  private static int jump2(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return 1;

    int result = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        int curPos = queue.poll();
        if (curPos >= nums.length - 1) {
          return result;
        }
        for (int i = 1; i <= nums[curPos]; i++) {
          int nextPos = curPos + i;
          queue.add(nextPos);
        }
      }
      result++;
    }
    return result;
  }
}
