package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 216. 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No216 {

  public static void main(String[] args) {
    List<List<Integer>> result = combinationSum3(3, 9);
    for (List<Integer> item : result) {
      System.out.println(item);
    }
  }

  public static List<List<Integer>> combinationSum3(int k, int n) {
    result.clear();
    Arrays.fill(visited, false);

    dfs(new LinkedList<>(), k, n);
    return result;
  }

  static List<List<Integer>> result = new ArrayList<>();
  static boolean[] visited = new boolean[10];

  public static void dfs(Deque<Integer> item, int k, int n) {
    if (n == 0) {
      if (k == 0) {
        result.add(new ArrayList<>(item));
      } else {
        return;
      }
    }

    for (int i = 1; i <= 9; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (n >= i && (item.isEmpty() || i >= item.peekLast())) {
          item.addLast(i);
          dfs(item, k - 1, n - i);
          item.removeLast();
        }
        visited[i] = false;
      }
    }
  }
}
