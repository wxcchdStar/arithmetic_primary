package leetcode;

/**
 * 相同的树
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */
public class No100 {

  public static void main(String[] args) {

  }

  private static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      boolean result = p.val == q.val;
      if (p.left != null && q.left != null) {
        result &= isSameTree(p.left, q.left);
      } else if (p.left != null || q.left != null) {
        return false;
      }
      if (p.right != null && q.right != null) {
        result &= isSameTree(p.right, q.right);
      } else if (p.right != null || q.right != null) {
        return false;
      }
      return result;
    } else {
      return p == null && q == null;
    }
  }
}
