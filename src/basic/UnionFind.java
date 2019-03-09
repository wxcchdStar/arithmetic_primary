package basic;

public class UnionFind {

  private int count;
  private int[] ids;

  public UnionFind(int M) {
    count = M;
    ids = new int[count];
    for (int i = 0; i < ids.length; i++) {
      ids[i] = i;
    }
  }

  public void quickFind(int p, int q) {
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

  public void quickUnion(int p, int q) {
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
}
