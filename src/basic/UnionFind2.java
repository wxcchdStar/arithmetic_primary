package basic;

public class UnionFind2 {

  private int count;
  private int[] ids;

  public UnionFind2(char[][] grid) {
    ids = new int[grid.length * grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          int id = i * grid[i].length + j;
          ids[id] = id;
          count++;
        }
      }
    }
  }

  public void union(int p, int q) {
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

  public int getCount() {
    return count;
  }
}
