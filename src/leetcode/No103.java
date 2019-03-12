package leetcode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class No103 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    for (List<Integer> list : levelOrderBottom(root)) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    boolean rightToLeft = true;

    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    while (!nodeQueue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      int size = nodeQueue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodeQueue.poll();
        if (rightToLeft) {
          levelList.add(node.val);
        } else {
          levelList.add(0, node.val);
        }
        // 1->3(5),2(3)->
        if (node.left != null) {
          nodeQueue.add(node.left);
        }
        if (node.right != null) {
          nodeQueue.add(node.right);
        }
      }
      result.add(levelList);
      rightToLeft = !rightToLeft;
    }

    return result;
  }

}
