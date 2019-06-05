package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 课程表
 * <p>
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class No207 {

  public static void main(String[] args) {
    System.out.println(canFinish2(3, new int[][]{
        {0, 2}, {1, 2}, {2, 0}
    }));
    System.out.println(canFinish3(3, new int[][]{
        {1, 0}, {2, 1}
    }));
  }

  // BFS解法
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] edges = new int[numCourses];
    for (int[] arr : prerequisites) {
      edges[arr[1]] += 1;
    }
    int count = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < numCourses; i++) {
      if (edges[i] == 0) {
        stack.push(i);
        count++;
      }
    }
    while (!stack.isEmpty()) {
      int i = stack.pop();
      for (int[] arr : prerequisites) {
        if (arr[0] == i) {
          edges[arr[1]] -= 1;
          if (edges[arr[1]] == 0) {
            stack.push(arr[1]);
            count++;
          }
        }
      }
    }
    return count == numCourses;
  }

  // 比较快，90ms减小到9ms
  public static boolean canFinish3(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    int[] edges = new int[numCourses];
    for (int[] arr : prerequisites) {
      edges[arr[1]] += 1;
      if (graph[arr[0]] == null) {
        graph[arr[0]] = new ArrayList<>();
      }
      graph[arr[0]].add(arr[1]);
    }

    int count = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < numCourses; i++) {
      if (edges[i] == 0) {
        stack.push(i);
        count++;
      }
    }
    while (!stack.isEmpty()) {
      int i = stack.pop();
      if (graph[i] != null) {
        for (int j : graph[i]) {
          edges[j] -= 1;
          if (edges[j] == 0) {
            stack.push(j);
            count++;
          }
        }
      }
    }
    return count == numCourses;
  }

  // DFS解法
  public static boolean canFinish2(int numCourses, int[][] prerequisites) {
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, visited, prerequisites)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfs(int v, boolean[] visited, int[][] prerequisites) {
    if (visited[v]) {
      return false;
    }

    visited[v] = true;

    for (int[] arr : prerequisites) {
      if (arr[0] == v && !dfs(arr[1], visited, prerequisites)) {
        return false;
      }
    }

    visited[v] = false;
    return true;
  }
}
