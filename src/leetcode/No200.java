package leetcode;

import basic.UnionFind2;

/**
 * 岛屿的个数
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class No200 {

  public static void main(String[] args) {
//    char[][] array = new char[][]{
//        {'1', '1', '1', '1', '0'},
//        {'1', '1', '0', '1', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '0', '0', '0'}
//    };
//    char[][] array = new char[][]{
//        {'1', '1', '0', '0', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '1', '0', '0'},
//        {'0', '0', '0', '1', '1'}
//    };
    char[][] array = new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    System.out.println(new No200().numIslands(array));
  }


  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    UnionFind2 unionFind2 = new UnionFind2(grid);

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          for (int[] d : distance) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length && grid[x][y] == '1') {
              int id1 = i * grid[i].length + j;
              int id2 = x * grid[i].length + y;
              unionFind2.union(id1, id2);
            }
          }
        }
      }
    }

    return unionFind2.getCount();
  }

}
