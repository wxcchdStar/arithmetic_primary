package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No040 {

  public static void main(String[] args) {
    List<List<Integer>> result = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    for (List<Integer> item : result) {
      System.out.println(item);
    }
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      List<Integer> temp = new ArrayList<>();
      temp.add(candidates[i]);
      boolean[] visited = new boolean[candidates.length];
      visited[i] = true;
      compute(result, candidates, temp, target, candidates[i], visited);
    }
    return result;
  }

  private static void compute(List<List<Integer>> result, int[] candidates, List<Integer> temp, int target, int i, boolean[] visited) {
    if (target - i < 0) {
      return;
    }

    temp.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    if (target - i == 0) {
      if (!result.contains(temp)) {
        result.add(temp);
      }
    } else {
      for (int m = 0; m < candidates.length; m++) {
        if (!visited[m] ) {
          List<Integer> temp2 = new ArrayList<>(temp);
          temp2.add(candidates[m]);
          boolean[] visited2 = Arrays.copyOf(visited, candidates.length);
          visited2[m] = true;
          compute(result, candidates, temp2, target - i, candidates[m], visited2);
        }
      }
    }
  }
}
