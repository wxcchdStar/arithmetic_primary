package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No153 {

  public static void main(String[] args) {
    System.out.println(new No153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    System.out.println(new No153().findMin(new int[]{3, 4, 5, 1, 2}));
    System.out.println(new No153().findMin(new int[]{1}));
    System.out.println(new No153().findMin(new int[]{2, 1}));
  }

  public int findMin(int[] nums) {
    int result = Integer.MAX_VALUE;
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] < nums[r]) {
        r = mid;
      } else if (nums[mid] >= nums[l]) {
        l = mid + 1;
      }
      result = Math.min(result, nums[mid]);
    }
    if (l == r) {
      result = Math.min(result, nums[l]);
    }
    return result;
  }
}
