package leetcode;

import basic.BinaryTree;

import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class No105 {

  public static void main(String[] args) {
//    System.out.println(BinaryTree.preorderTravel2(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})));
    /*
             1
          2
       3
    */
    System.out.println(BinaryTree.preorderTravel2(buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1})));
  }

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    addTreeNode(root, preorder, inorder);
    return root;
  }

  private static void addTreeNode(TreeNode root, int[] preorder, int[] inorder) {
    int rootIndex = search(inorder, root.val);
//    System.out.println(rootIndex + ": " + root.val + " in " + Arrays.toString(inorder));
    if (rootIndex >= 1) {
      int[] preorder2 = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
      int[] inorder2 = Arrays.copyOfRange(inorder, 0, rootIndex);
//      System.out.println("left\t" + Arrays.toString(preorder2) + ", " + Arrays.toString(inorder2));
      root.left = new TreeNode(preorder2[0]);
      addTreeNode(root.left, preorder2, inorder2);
    }

    if (rootIndex > -1 && rootIndex < inorder.length - 1) {
      int[] preorder2 = Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length);
      int[] inorder2 = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
//      System.out.println("right\t" + Arrays.toString(preorder2) + ", " + Arrays.toString(inorder2));
      root.right = new TreeNode(preorder2[0]);
      addTreeNode(root.right, preorder2, inorder2);
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
