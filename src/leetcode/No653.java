package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Two Sum IV - Input is a BST
 */
public class No653 {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

  }

  // 方法一, 11%
  private static boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return find(set, root, k);
  }

  private static boolean find(Set<Integer> set, TreeNode root, int k) {
    if (root == null) return false;

    if (set.contains(root.val)) return true;

    set.add(k - root.val);

    return find(set, root.left, k) || find(set, root.right, k);
  }

  // 方法二, 99%
  private static boolean findTarget2(TreeNode root, int k) {
    if (root == null) return false;
    return helper(root, root, k);
  }

  private static boolean helper(TreeNode cur, TreeNode root, int k) {
    int need = k - cur.val;
    if (cur.val != need && findOther(root, need)) {
      return true;
    }
    if (cur.left != null && helper(cur.left, root, k)) {
      return true;
    }
    return cur.right != null && helper(cur.right, root, k);
  }

  private static boolean findOther(TreeNode root, int need) {
    if (root == null) return false;
    if (root.val == need) return true;
    if (root.val < need) {
      return findOther(root.right, need);
    } else {
      return findOther(root.left, need);
    }
  }

  // 方法三, 61%
  private static boolean findTarget3(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    convertToList(list, root);

    int l = 0, r = list.size() - 1;
    while (l < r) {
      int sum = list.get(l) + list.get(r);
      if (sum == k) {
        return true;
      } else if (sum < k) {
        l++;
      } else {
        r--;
      }
    }
    return false;
  }

  private static void convertToList(List<Integer> list, TreeNode root) {
    if (root == null) return;

    convertToList(list, root.left);
    list.add(root.val);
    convertToList(list, root.right);
  }
}
