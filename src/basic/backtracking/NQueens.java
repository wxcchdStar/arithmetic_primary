package basic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class NQueens {

  public static void main(String[] args) {
    for (List<String> list : solveNQueens(4)) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  private static List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    // 初始化棋盘
    String[][] chessboard = new String[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(chessboard[i], ".");
    }
    // 扫描
    dfs(result, chessboard, 0);
    return result;
  }

  private static void dfs(List<List<String>> result, String[][] chessboard, int y) {
    if (y == chessboard.length) {
      saveResult(result, chessboard);
      return;
    }
    for (int i = 0; i < chessboard.length; i++) {
      if (check(chessboard, i, y)) {
        chessboard[i][y] = "Q";
        dfs(result, chessboard, y + 1);
        chessboard[i][y] = ".";
      }
    }
  }

  private static boolean check(String[][] chessboard, int x, int y) {
    // 只检查北向的即可，不需要检查南向
    for (int i = 0; i < y; i++) {
      // 检查北向
      if (chessboard[x][i].equals("Q")) {
        return false;
      }
      // 检查西北向
      if (x - 1 - i >= 0 && chessboard[x - 1 - i][y - 1 - i].equals("Q")) {
        return false;
      }
      // 检查东北向
      if (x + 1 + i < chessboard.length && chessboard[x + 1 + i][y - 1 - i].equals("Q")) {
        return false;
      }
    }
    return true;
  }

  private static void saveResult(List<List<String>> result, String[][] chessboard) {
    List<String> aResult = new ArrayList<>();
    for (String[] arr : chessboard) {
      String item = "";
      for (String str : arr) {
        item += str;
      }
      aResult.add(item);
    }
    result.add(aResult);
  }
}