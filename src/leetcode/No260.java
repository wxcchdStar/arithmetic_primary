package leetcode;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class No260 {

  public int[] singleNumber(int[] nums) {
    int num1 = 0, num2 = 0;
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }

    int bit_1 = 1;
    while ((xor & 1) == 0) {
      xor >>= 1;
      bit_1 <<= 1;
    }

    for (int num : nums) {
      if ((num & bit_1) == 0) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }

    return new int[]{num1, num2};
  }
}
