package basic;

import leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树
 */
public class BinaryTree {

  public static void main(String[] args) {
    /*
     *              3
     *        9          20
     *     7    10    15    17
     */
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(10);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(17);
    System.out.println(Arrays.toString(preorderTravel(root).toArray()));
    System.out.println(Arrays.toString(preorderTravel2(root).toArray()));
    System.out.println(Arrays.toString(preorderTravel2_2(root).toArray()));
    System.out.println(Arrays.toString(levelTravel(root).toArray()));

    System.out.println(Arrays.toString(postorderTravel(root).toArray()));
    System.out.println(Arrays.toString(postorderTravel2(root).toArray()));
  }

  // 前序遍历：递归实现
  private static List<Integer> preorderTravel(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    if (node != null) {
      result.add(node.val);
      result.addAll(preorderTravel(node.left));
      result.addAll(preorderTravel(node.right));
    }
    return result;
  }

  // 前序遍历：栈实现
  public static List<Integer> preorderTravel2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        // 由于栈是先进后出，所以先存放右节点
        if (node.right != null) {
          stack.push(node.right);
        }
        if (node.left != null) {
          stack.push(node.left);
        }
      }
    }
    return result;
  }

  // 前序遍历：栈实现2
  public static List<Integer> preorderTravel2_2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      while (root != null || !stack.isEmpty()) {
        if (root != null) {
          result.add(root.val);
          stack.push(root);
          root = root.left;
        } else {
          root = stack.pop();
          root = root.right;
        }
      }
    }
    return result;
  }

  // 层级遍历
  public static List<Integer> levelTravel(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        // 在此处取出queue的size，然后使用for循环，即可方便地计算数的层级
        TreeNode node = queue.poll();
        result.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return result;
  }

  // 后序遍历：栈实现，先插入右侧的，然后再插入左侧
  public static List<Integer> postorderTravel(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node.left != null) {
          stack.push(node.left);
        }
        if (node.right != null) {
          stack.push(node.right);
        }
        result.add(0, node.val);
      }
    }
    return result;
  }

  // 后序遍历：栈实现，先插入右侧的，然后再插入左侧
  public static List<Integer> postorderTravel2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      while (root != null || !stack.isEmpty()) {
        if (root == null) {
          root = stack.pop().left;
        } else {
          result.add(0, root.val);
          stack.push(root);
          root = root.right;
        }
      }
    }
    return result;
  }
}
