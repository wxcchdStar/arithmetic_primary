package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class No101 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    System.out.println(isSymmetric(root));
    System.out.println(isSymmetric2(root));
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static boolean isSymmetric(TreeNode root) {
    return test(root, root);
  }

  private static boolean test(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return left.val == right.val && test(left.left, right.right)
        && test(left.right, right.left);
  }

  private static boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();

      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;

      queue.add(t1.left);
      queue.add(t2.right);
      queue.add(t1.right);
      queue.add(t2.left);
    }

    return true;
  }
}
