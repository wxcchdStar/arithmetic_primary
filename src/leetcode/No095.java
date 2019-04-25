package leetcode;

import basic.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class No095 {

  public static void main(String[] args) {
    for (TreeNode node : generateTrees(3)) {
      System.out.println(Arrays.toString(BinaryTree.preorderTravel2(node).toArray()));
    }
  }

  private static List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<>();
    return test(1, n);
  }

  private static List<TreeNode> test(int start, int end) {
    List<TreeNode> treeNodeList = new ArrayList<>();

    if (start > end) {
      treeNodeList.add(null);
      return treeNodeList;
    }

    if (start == end) {
      treeNodeList.add(new TreeNode(start));
      return treeNodeList;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = test(start, i - 1);
      List<TreeNode> rightList = test(i + 1, end);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode node = new TreeNode(i);
          node.left = left;
          node.right = right;
          treeNodeList.add(node);
        }
      }
    }
    return treeNodeList;
  }
}
