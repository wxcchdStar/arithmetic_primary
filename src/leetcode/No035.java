package leetcode;

/**
 * 35. 搜索插入位置
 */
public class No035 {

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
  }

  public static int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int index = (end + start) / 2;
      if (nums[index] == target) {
        return index;
      } else if (nums[index] > target) {
        end = index - 1;
      } else {
        start = index + 1;
      }
    }
    return start;
  }
}
