package leetcode;

import java.util.Arrays;

/**
 * 数组拆分I
 * <p>
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * 1.n 是正整数,范围在 [1, 10000].
 * 2.数组中的元素范围在 [-10000, 10000].
 *
 * @author chenhd
 */
public class No561 {

  public static void main(String[] args) {
    System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
  }

  public static int arrayPairSum(int[] nums) {
    Arrays.sort(nums);

    int result = 0;
    for (int i = 0; i < nums.length; i += 2) {
      result += nums[i];
    }

    return result;
  }
}
