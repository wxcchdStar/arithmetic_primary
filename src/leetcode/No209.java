package leetcode;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No209 {

  public static void main(String[] args) {
//    System.out.println(new No209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    System.out.println(new No209().minSubArrayLen(3, new int[]{1, 1}));
  }

  public int minSubArrayLen(int s, int[] nums) {
    int result = nums.length + 1;
    int sum = 0;
    int i = 0, j = 0;
    while (i < nums.length) {
      sum += nums[i];
      while (sum >= s) {
        result = Math.min(result, i - j + 1);
        sum -= nums[j];
        j++;
      }
      i++;
    }
    return result == nums.length + 1 ? 0 : result;
  }
}
