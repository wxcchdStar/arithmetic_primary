package leetcode;

public class No053 {

  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  private static int maxSubArray(int[] nums) {
    int res = nums[0];
    int sum = 0;
    for (int num : nums) {
      if (sum > 0) {
        sum += num;
      } else {
        sum = num;
      }
      res = Math.max(res, sum);
    }
    return res;
  }
}
