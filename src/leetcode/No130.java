package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
    // 此问题也可以使用并查集去做，将所有边界的O节点及其联通的节点联通到一个虚拟节点上
    // 然后将所有其他的与虚拟节点不连通的节点均置为X
    char[][] board = new char[][]{
        {'X', 'O', 'X', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'X'}
    };
    solve(board);
    System.out.println("----------------");
    print(board);
  }

  private static void print(char[][] board) {
    for (char[] arrs : board) {
      for (char c : arrs) {
        System.out.print(c + " ");
      }
      System.out.println();
    }
  }

  private static void solve(char[][] board) {
    // 将不会变为X的O填充为T
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'O') {
          bfsFill(board, i, j);
        }
      }
    }
    // 将所有O填充为X
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
    // 将所有T填充为O
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'T') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private static void bfsFill(char[][] board, int i, int j) {
    if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
      board[i][j] = 'T';

      int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      Queue<Integer> queue = new LinkedList<>();
      queue.add(i * board[0].length + j);

      while (!queue.isEmpty()) {
        int k = queue.poll();
        for (int[] point : distance) {
          int x = k / board[0].length + point[0];
          int y = k % board[0].length + point[1];
          if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
            board[x][y] = 'T';
            queue.add(x * board[0].length + y);
          }
        }
      }
    }
  }
}
