package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 */
public class No104 {

  private static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int result = 0;

    Queue<TreeNode> stack = new LinkedList<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      result++;
      int size = stack.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = stack.poll();
        if (treeNode.right != null) {
          stack.add(treeNode.right);
        }
        if (treeNode.left != null) {
          stack.add(treeNode.left);
        }
      }
    }

    return result;
  }

}
