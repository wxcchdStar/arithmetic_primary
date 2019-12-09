package leetcode;

import java.util.Arrays;

/**
 * 152. 乘积最大子序列
 * <p>
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No152 {

  public static void main(String[] args) {
    System.out.println(maxProduct2(new int[]{2, 3, -2, 4}));
  }

  private static int maxProduct2(int[] nums) {
    int result = nums[0];
    int max = 1;
    int min = 1;

    for(int num : nums) {
      if (num < 0) {
        int temp = max;
        max = min;
        min = temp;
      }
      max = Math.max(num, max * num);
      min = Math.min(num, min * num);
      result = Math.max(result, max);
    }

    return  result;
  }

  private static int maxProduct(int[] nums) {
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int temp = 1;
        for (int k = i; k <= j; k++) {
          temp *= nums[k];
        }
        result = Math.max(result, temp);
      }
    }
    return result;
  }
}
