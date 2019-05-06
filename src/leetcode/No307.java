package leetcode;

/**
 * 区域和检索 - 数组可修改
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
public class No307 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 5};
    NumArray obj = new NumArray(nums);
    System.out.println(obj.sumRange(0, 2));
    obj.update(1, 2);
    System.out.println(obj.sumRange(0, 2));
  }

  static class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
      this.nums = nums;
    }

    public void update(int i, int val) {
      nums[i] = val;
    }

    public int sumRange(int i, int j) {
      int result = 0;
      for (int k = i; k <= j; k++) {
        result += nums[k];
      }
      return result;
    }
  }
}
