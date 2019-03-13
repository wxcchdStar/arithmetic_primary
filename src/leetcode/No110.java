package leetcode;

public class No110 {

  private static boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return Math.abs(deepth(root.left) - deepth(root.right)) <= 1
        && isBalanced(root.left) && isBalanced(root.right);
  }

  private static int deepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(deepth(root.left), deepth(root.right)) + 1;
  }
}
