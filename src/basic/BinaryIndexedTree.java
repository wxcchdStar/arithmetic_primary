package basic;

import java.util.Arrays;

/**
 * 树状数组
 *
 * 比线段树更简洁，树状数组能做的线段树也可以，反之则不行
 *
 * @author chenhd
 */
public class BinaryIndexedTree {

  private int[] nums;
  private int[] BIT;
  private int n;

  public BinaryIndexedTree(int[] nums) {
    this.nums = nums;
    this.n = nums.length;
    this.BIT = new int[n + 1];
    for (int i = 0; i < n; i++) {
      updateDelta(i, nums[i]);
    }
    System.out.println(Arrays.toString(BIT));
  }

  private int lowbit(int x) {
    // 等价于 x & (x ^ (x - 1))
    return x & -x;
  }

  private void updateDelta(int i, int delta) {
    i++;
    while (i <= n) {
      BIT[i] += delta;
      i += lowbit(i);
    }
  }

  public void update(int i, int val) {
    int diff = val - nums[i];
    nums[i] = val;
    updateDelta(i, diff);
  }

  public int getSum(int i) {
    int sum = 0;
    i++;
    while (i > 0) {
      sum += BIT[i];
      i -= lowbit(i);
    }
    return sum;
  }

  public int sumRange(int i, int j) {
    return getSum(j) - getSum(i - 1);
  }

  public static void main(String[] args) {
    BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{1, 3, 5});
    System.out.println(bit.sumRange(0, 2));
    bit.update(1, 2);
    System.out.println(bit.sumRange(0, 2));
  }
}
