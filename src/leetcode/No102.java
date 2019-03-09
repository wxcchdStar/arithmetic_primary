package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class No102 {

  public static void main(String[] args) {

  }

  private static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    while (!nodeQueue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      int size = nodeQueue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodeQueue.poll();
        levelList.add(node.val);
        if (node.left != null) {
          nodeQueue.add(node.left);
        }
        if (node.right != null) {
          nodeQueue.add(node.right);
        }
      }
      result.add(levelList);
    }

    return result;
  }

}
