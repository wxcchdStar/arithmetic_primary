package leetcode;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No033_2 {

  public static void main(String[] args) {
    System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  private static int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      // 当[0,mid]有序时,向后规约条件
      if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
        lo = mid + 1;
        // 当[0,mid]发生旋转时，向后规约条件
      } else if (target > nums[mid] && target < nums[0]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo == hi && nums[lo] == target ? lo : -1;
  }

}
