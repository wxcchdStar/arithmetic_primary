package leetcode;

/**
 * 137. 只出现一次的数字 II
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class No137 {

  public static int singleNumber(int[] nums) {
    int[] count = new int[32];
    int result = 0;
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (((nums[j] >> i) & 1) == 1) {
          count[i]++;
        }
      }
      result |= ((count[i] % 3) << i);
    }
    return result;
  }
}
