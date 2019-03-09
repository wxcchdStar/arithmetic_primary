package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class No094 {


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    System.out.println(Arrays.toString(inorderTraversal2(root).toArray()));
  }

  private static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    test(result, root);
    return result;
  }

  private static void test(List<Integer> result, TreeNode root) {
    if (root != null) {
      test(result, root.left);
      result.add(root.val);
      test(result, root.right);
    }
  }

  private static List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.add(root);
        root = root.left;
      } else {
        root = stack.pop();
        result.add(root.val);
        root = root.right;
      }
    }
    return result;
  }

}
