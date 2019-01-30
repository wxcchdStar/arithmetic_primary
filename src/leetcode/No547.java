package leetcode;

import java.util.Arrays;

/**
 * 547. 朋友圈
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class No547 {

  public static void main(String[] args) {
//    System.out.println(findCircleNum(new int[][]{
//        {1, 1, 0},
//        {1, 1, 0},
//        {0, 0, 1}
//    }));
//    System.out.println(findCircleNum(new int[][]{
//        {1, 1, 0},
//        {1, 1, 1},
//        {0, 1, 1}
//    }));
//    System.out.println(findCircleNum(new int[][]{
//        {1, 1, 1},
//        {1, 1, 1},
//        {1, 1, 1}
//    }));
//    System.out.println(findCircleNum(new int[][]{
//        {1, 0, 0},
//        {1, 1, 0},
//        {0, 0, 1}
//    }));
//    System.out.println(findCircleNum(new int[][]{
//        {1, 0, 0, 1},
//        {0, 1, 1, 0},
//        {0, 1, 1, 1},
//        {1, 0, 1, 1}
//    }));
    System.out.println(findCircleNum2(new int[][]{
        {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
        {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}
    }));
  }

  private static int findCircleNum(int[][] M) {
    int result = M.length;
    int[] temp = new int[M.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = i;
    }
    System.out.println(Arrays.toString(temp));

    for (int i = 0; i < M.length; i++) {
      for (int j = i + 1; j < M[i].length; j++) {
        if (M[i][j] == 1) {
          result = quickUnion(temp, i, j, result);
          System.out.println(i + ", " + j + " \t " + Arrays.toString(temp));
        }
      }
    }
    return result;
  }

  private static int quickFind(int[] array, int p, int q, int result) {
    int pV = array[p];
    int qV = array[q];
    if (pV == qV) {
      return result;
    }

    for (int i = 0; i < array.length; i++) {
      if (array[i] == pV) {
        array[i] = qV;
      }
    }

    return result - 1;
  }

  private static int quickUnion(int[] array, int p, int q, int result) {
    int pV = findRoot(array, p);
    int qV = findRoot(array, q);

    if (pV == qV) {
      return result;
    }

    array[pV] = qV;
    return result - 1;
  }

  private static int findRoot(int[] array, int p) {
    while (p != array[p]) {
      p = array[p];
    }
    return p;
  }

  private static int findCircleNum2(int[][] M) {
    int result = M.length;
    int[] temp = new int[M.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = i;
    }
    int[] sz = new int[M.length];
    for (int i = 0; i < sz.length; i++) {
      sz[i] = 1;
    }
    for (int i = 0; i < M.length; i++) {
      for (int j = i + 1; j < M[i].length; j++) {
        if (M[i][j] == 1) {
          result = quickUnion2(temp, i, j, result, sz);
          System.out.println(i + ", " + j + " \t " + Arrays.toString(temp));
        }
      }
    }
    return result;
  }

  private static int quickUnion2(int[] array, int p, int q, int result, int[] sz) {
    int pV = findRoot(array, p);
    int qV = findRoot(array, q);

    if (pV == qV) {
      return result;
    }

    if (sz[pV] < sz[qV]) {
      array[pV] = qV;
      sz[qV] += sz[pV];
    } else {
      array[qV] = pV;
      sz[pV] += sz[qV];
    }

    return result - 1;
  }

  private static int quickUnion3(int[] id, int p, int q, int result) {
    int rootP = find3(id, p);
    int rootQ = find3(id, q);
    if (rootP == rootQ) {
      return result;
    }
    id[rootP] = rootQ;
    return result - 1;
  }

  private static int find3(int[] id, int p) {
    int root = p;
    while (root != id[root]) {
      root = id[root];
    }
    while (p != root) {
      int newp = id[p];
      id[p] = root;
      p = newp;
    }
    return root;
  }
}
