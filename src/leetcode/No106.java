package leetcode;

import basic.BinaryTree;

import java.util.Arrays;

/**
 * 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
public class No106 {

  public static void main(String[] args) {
    System.out.println(BinaryTree.preorderTravel2(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3})));
  }

  private static TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    addTreeNode(root, inorder, postorder);
    return root;
  }

  private static void addTreeNode(TreeNode root, int[] inorder, int[] postorder) {
    int rootIndex = search(inorder, root.val);
    if (rootIndex >= 1) {
      int[] inorder2 = Arrays.copyOfRange(inorder, 0, rootIndex);
      int[] postorder2 = Arrays.copyOfRange(postorder, 0, rootIndex);
      root.left = new TreeNode(postorder2[postorder2.length - 1]);
      addTreeNode(root.left, inorder2, postorder2);
    }

    if (rootIndex >= 0 && rootIndex < inorder.length - 1) {
      int[] inorder2 = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
      int[] postorder2 = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
      root.right = new TreeNode(postorder2[postorder2.length - 1]);
      addTreeNode(root.right, inorder2, postorder2);
    }
  }

  private static int search(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }

}
