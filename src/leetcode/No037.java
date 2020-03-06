package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 37. 解数独
 * <p>
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No037 {

  public static void main(String[] args) {
//    char[][] board = new char[][]{
//        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//        {'.', '.', '.', '4', '1', '9', '.', '3', '5'},
//        {'.', '.', '.', '.', '8', '.', '.', '7', '.'}
//    };

    char[][] board = new char[][]{
        {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
    };

    solveSudoku(board);
    for (char[] row : board) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void solveSudoku(char[][] board) {
    isResolve = false;
    for (int i = 0; i < 9; i++) {
      rowSet[i] = new HashSet<>();
      columnSet[i] = new HashSet<>();
      boxSet[i] = new HashSet<>();
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          rowSet[i].add(board[i][j]);
          columnSet[j].add(board[i][j]);
          boxSet[boxIndex(i, j)].add(board[i][j]);
        }
      }
    }

    dfs(board, 0, 0);
  }

  static HashSet<Character>[] rowSet = new HashSet[9];
  static HashSet<Character>[] columnSet = new HashSet[9];
  static HashSet<Character>[] boxSet = new HashSet[9];

  private static int boxIndex(int x, int y) {
    return x / 3 * 3 + y / 3;
  }

  private static boolean isResolve = false;

  private static void dfs(char[][] board, int x, int y) {
    if (x == board.length || y == board.length) {
      isResolve = true;
      return;
    }

    if (board[x][y] == '.') {
      for (int n = 1; n <= 9; n++) {
        char c = (char) ('0' + n);
        int boxIndex = boxIndex(x, y);
        if (!rowSet[x].contains(c) && !columnSet[y].contains(c) && !boxSet[boxIndex].contains(c)) {
          board[x][y] = c;
          rowSet[x].add(c);
          columnSet[y].add(c);
          boxSet[boxIndex].add(c);

          if (y >= board[0].length - 1) {
            dfs(board, x + 1, 0);
          } else {
            dfs(board, x, y + 1);
          }

          if (!isResolve) {
            board[x][y] = '.';
            rowSet[x].remove(c);
            columnSet[y].remove(c);
            boxSet[boxIndex].remove(c);
          }
        }
      }
    } else {
      if (y >= board[0].length - 1) {
        dfs(board, x + 1, 0);
      } else {
        dfs(board, x, y + 1);
      }
    }
  }
}
