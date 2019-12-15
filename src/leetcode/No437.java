package leetcode;

import java.util.HashMap;

/**
 * 437. 路径总和 III
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No437 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);

    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(11);

    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);

    root.left.right.right = new TreeNode(1);

    System.out.println(new No437().pathSum(root, 8));
  }

  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;

    return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int count(TreeNode root, int sum) {
    if (root == null) return 0;
    int result = root.val == sum ? 1 : 0;
    return result + count(root.left, sum - root.val) + count(root.right, sum - root.val);
  }

  public int pathSum2(TreeNode root, int sum) {
    if (root == null) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }
}
