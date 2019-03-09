package leetcode;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class No107 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(17);
    List<List<Integer>> result = levelOrderBottom(root);
    for (List<Integer> list : result) {
      System.out.println(Arrays.toString(list.toArray()));
    }
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
      result.add(0, levelList);
    }

    return result;
  }

}
