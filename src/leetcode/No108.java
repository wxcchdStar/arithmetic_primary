package leetcode;

/**
 * 将有序数组转换为二叉搜索树
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class No108 {

  public static void main(String[] args) {
    sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
  }

  private static TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;

    return helper(nums, 0, nums.length - 1);
  }

  private static TreeNode helper(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = (high + low) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums, low, mid - 1);
    node.right = helper(nums, mid + 1, high);
    return node;
  }
}
