package leetcode;

import java.util.Arrays;

/**
 * 1034. 边框着色
 * <p>
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 * <p>
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * <p>
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 *  
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1034 {

  public static void main(String[] args) {
    int[][] result = new No1034().colorBorder(new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    }, 1, 1, 2);

    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
    System.out.println("---------------");

    result = new No1034().colorBorder(new int[][]{
        {1, 2, 2},
        {2, 3, 2}
    }, 0, 1, 3);

    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
    System.out.println("-----------------");

    result = new No1034().colorBorder(new int[][]{
        {1, 2, 1, 2, 1, 2},
        {2, 2, 2, 2, 1, 2},
        {1, 2, 2, 2, 1, 2}
    }, 1, 3, 1);

    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    colorBorder(grid, r0, c0, color, grid[r0][c0], visited);
    return grid;
  }

  public void colorBorder(int[][] grid, int r0, int c0, int color, int oldColor, boolean[][] visited) {
    if (r0 < 0 || r0 >= grid.length || c0 < 0 || c0 >= grid[0].length) return;
    if (grid[r0][c0] != oldColor) return;
    if (visited[r0][c0]) return;
    visited[r0][c0] = true;

    boolean isTopBorder = isTopBorder(grid, r0, c0, oldColor);
    boolean isBottomBorder = isBottomBorder(grid, r0, c0, oldColor);
    boolean isLeftBorder = isLeftBorder(grid, r0, c0, oldColor);
    boolean isRightBorder = isRightBorder(grid, r0, c0, oldColor);

    if (isTopBorder || isBottomBorder || isLeftBorder || isRightBorder) {
      grid[r0][c0] = -1;
    }

    colorBorder(grid, r0, c0 - 1, color, oldColor, visited);
    colorBorder(grid, r0, c0 + 1, color, oldColor, visited);
    colorBorder(grid, r0 - 1, c0, color, oldColor, visited);
    colorBorder(grid, r0 + 1, c0, color, oldColor, visited);

    if (isTopBorder || isBottomBorder || isLeftBorder || isRightBorder) {
      grid[r0][c0] = color;
    }
  }

  private static boolean isTopBorder(int[][] grid, int r0, int c0, int oldColor) {
    return (c0 == 0) || (c0 - 1 >= 0 && grid[r0][c0 - 1] != oldColor && grid[r0][c0 - 1] != -1);
  }

  private static boolean isBottomBorder(int[][] grid, int r0, int c0, int oldColor) {
    return (c0 == grid[0].length - 1) || (c0 + 1 <= grid[0].length - 1 && grid[r0][c0 + 1] != oldColor && grid[r0][c0 + 1] != -1);
  }

  private static boolean isLeftBorder(int[][] grid, int r0, int c0, int oldColor) {
    return (r0 == 0) || (r0 - 1 >= 0 && grid[r0 - 1][c0] != oldColor && grid[r0 - 1][c0] != -1);
  }

  private static boolean isRightBorder(int[][] grid, int r0, int c0, int oldColor) {
    return (r0 == grid.length - 1) || (r0 + 1 <= grid.length - 1 && grid[r0 + 1][c0] != oldColor && grid[r0 + 1][c0] != -1);
  }

}
