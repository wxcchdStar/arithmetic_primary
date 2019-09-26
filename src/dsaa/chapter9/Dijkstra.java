package dsaa.chapter9;

import java.util.*;

public class Dijkstra {

  public static void main(String[] args) {
    BellmanFord.Edge st = new BellmanFord.Edge('s', 't', 10);
    BellmanFord.Edge sy = new BellmanFord.Edge('s', 'y', 5);
    BellmanFord.Edge tx = new BellmanFord.Edge('t', 'x', 1);
    BellmanFord.Edge ty = new BellmanFord.Edge('t', 'y', 2);
    BellmanFord.Edge yt = new BellmanFord.Edge('y', 't', 3);
    BellmanFord.Edge yz = new BellmanFord.Edge('y', 'z', 2);
    BellmanFord.Edge yx = new BellmanFord.Edge('y', 'x', 9);
    BellmanFord.Edge xz = new BellmanFord.Edge('x', 'z', 4);
    BellmanFord.Edge zx = new BellmanFord.Edge('z', 'x', 6);
    BellmanFord.Edge zs = new BellmanFord.Edge('z', 's', 7);
    BellmanFord.Edge[] edges = new BellmanFord.Edge[]{st, sy, ty, yt, yz, yx, tx, xz, zx, zs};

    // 第一步：初始化距离，初始化原点距离为0
    char[] nodes = new char[]{'s', 't', 'x', 'y', 'z'};
    Map<Character, Integer> distance = new HashMap<>(nodes.length);
    for (char c : nodes) {
      distance.put(c, Integer.MAX_VALUE);
    }
    distance.put('s', 0);

    // 第二步：初始化一个空集合，存放已计算过的节点
    Set<Character> s = new HashSet<>(nodes.length);

    // 第三步：取出d值最小的顶点，并对其进行'松弛'
    while (s.size() < nodes.length) {
      char u = ' ';
      int min = Integer.MAX_VALUE;
      for (Map.Entry<Character, Integer> entry : distance.entrySet()) {
        if (!s.contains(entry.getKey()) && distance.get(entry.getKey()) < min) {
          min = distance.get(entry.getKey());
          u = entry.getKey();
        }
      }
      s.add(u);
      System.out.println(u + ", " + distance.get(u));

      // 取出所有以u为出发点的边
      for (BellmanFord.Edge edge : edges) {
        if (edge.u == u && distance.get(edge.u) != Integer.MAX_VALUE && distance.get(edge.v) > distance.get(edge.u) + edge.w) {
          distance.put(edge.v, distance.get(edge.u) + edge.w);
        }
      }

      for (Map.Entry<Character, Integer> entry : distance.entrySet()) {
        System.out.println(entry.getKey() + "\t" + entry.getValue());
      }
      System.out.println("-------------");
    }


  }
}
