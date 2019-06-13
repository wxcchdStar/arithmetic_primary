package leetcode;

import java.util.*;

/**
 * 最小高度树
 * <p>
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * <p>
 * 格式
 * <p>
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 * <p>
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: [1]
 * 示例 2:
 * <p>
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * 输出: [3, 4]
 * 说明:
 * <p>
 *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No310 {

  public static void main(String[] args) {
//    System.out.println(findMinHeightTrees(6, new int[][]{
//        {0, 3},
//        {1, 3},
//        {2, 3},
//        {4, 3},
//        {5, 4}
//    }));
    System.out.println(findMinHeightTrees(4, new int[][]{
        {1, 0},
        {1, 2},
        {1, 3}
    }));
  }

  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 1) {
      result.add(0);
      return result;
    }

    List<ArrayList<Integer>> graph = new ArrayList<>();
    int[] degree = new int[n];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
      degree[edge[0]]++;
      degree[edge[1]]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      if (degree[i] == 1) {
        queue.offer(i);
      } else if (degree[i] == 0) {
        return result;
      }
    }

    while (!queue.isEmpty()) {
      result = new ArrayList<>();

      int count = queue.size();
      for (int i = 0; i < count; i++) {
        int node = queue.poll();
        result.add(node);

        List<Integer> edgeNode = graph.get(node);
        for (Integer next : edgeNode) {
          degree[next]--;
          if (degree[next] == 1) {
            queue.offer(next);
          }
        }
      }
    }

    return result;
  }
}
