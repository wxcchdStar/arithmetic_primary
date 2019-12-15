package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No113 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);

//    TreeNode root = new TreeNode(5);
//    root.left = new TreeNode(4);
//    root.right = new TreeNode(8);
//
//    root.left.left = new TreeNode(11);
//    root.left.left.left = new TreeNode(7);
//    root.left.left.right = new TreeNode(2);
//
//    root.right.left = new TreeNode(13);
//    root.right.right = new TreeNode(4);
//
//    root.right.right.left = new TreeNode(5);
//    root.right.right.right = new TreeNode(1);

    List<List<Integer>> result = new No113().pathSum(root, 1);
    for (List<Integer> integers : result) {
      System.out.println(integers);
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    List<Integer> list = new ArrayList<>();
    list.add(root.val);
    test(result, list, root, sum - root.val);
    return result;
  }

  private void test(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
    if (root == null) return;

    if ((root.left == null && root.right == null) && sum == 0) {
      result.add(new ArrayList<>(list));
      return;
    }

    if (root.left != null) {
      list.add(root.left.val);
//      System.out.println(Arrays.toString(list.toArray()));
      test(result, list, root.left, sum - root.left.val);
      list.remove(list.size() - 1);
    }

    if (root.right != null) {
      list.add(root.right.val);
      test(result, list, root.right, sum - root.right.val);
      list.remove(list.size() - 1);
    }
  }
}
