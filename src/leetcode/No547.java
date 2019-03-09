package leetcode;

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
    System.out.println(new No547().findCircleNum(new int[][]{
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}
    }));
    System.out.println(new No547().findCircleNum(new int[][]{
        {1, 1, 0},
        {1, 1, 1},
        {0, 1, 1}
    }));
    System.out.println(new No547().findCircleNum(new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    }));
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
//    System.out.println(findCircleNum(new int[][]{
//        {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
//        {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
//        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
//        {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
//        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
//        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
//        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
//        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1}
//    }));
  }

  private int count;
  private int[] ids;

  public int findCircleNum(int[][] M) {
    count = M.length;
    ids = new int[M.length];
    for (int i = 0; i < ids.length; i++) {
      ids[i] = i;
    }

    for (int i = 0; i < M.length - 1; i++) {
      for (int j = i + 1; j < M[i].length; j++) {
        if (M[i][j] == 1) {
          union(i, j);
        }
      }
    }

    return count;
  }

  private void unionFind(int p, int q) {
    int pId = ids[p];
    int qId = ids[q];

    if (qId == pId) return;

    for (int i = 0; i < ids.length; i++) {
      if (ids[i] == pId) {
        ids[i] = qId;
      }
    }
    count--;
  }

  private void quickUnion(int p, int q) {
    int pId = quickUnionFind(p);
    int qId = quickUnionFind(q);

    if (qId == pId) return;

    ids[pId] = qId;
    count--;
  }

  private int quickUnionFind(int p) {
    while (p != ids[p]) {
      p = ids[p];
    }
    return p;
  }

  private void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);

    if (qId == pId) return;

    ids[pId] = qId;
    count--;
  }

  private int find(int p) {
    // 找到根节点
    int root = p;
    while (root != ids[root]) {
      root = ids[root];
    }
    // 将p路径上的所有父节点全都指向根节点
    while (p != root) {
      int parent = ids[p];
      ids[parent] = root;
      p = parent;
    }
    return root;
  }
}
