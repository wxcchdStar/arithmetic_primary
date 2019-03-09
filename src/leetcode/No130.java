package leetcode;

/**
 * 被围绕的区域
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class No130 {

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'X', 'X', 'X', 'X'},
        {'X', '0', '0', 'X'},
        {'X', 'X', '0', 'X'},
        {'X', '0', 'X', 'X'}
    };
    solve(board);
    for (char[] arrs : board) {
      for (char c : arrs) {
        System.out.print(c + " ");
      }
      System.out.println();
    }
  }

  private static void solve(char[][] board) {
    int[][] distance = new int[][]{
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    for (int i = 1; i < board.length - 1; i++) {
      for (int j = 1; j < board[i].length - 1; j++) {
      }
    }
  }
}
