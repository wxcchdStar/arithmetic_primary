package dsaa.chapter9;

import java.util.HashMap;
import java.util.Map;

public class BellmanFord {

  public static class Edge {
    public char u;
    public char v;
    public int w;

    public Edge(char u, char v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public String toString() {
      return u + "-" + v + "=" + w;
    }
  }

  public static void main(String[] args) {
    Edge st = new Edge('s', 't', 6);
    Edge sy = new Edge('s', 'y', 7);
    Edge ty = new Edge('t', 'y', 8);
    Edge tx = new Edge('t', 'x', 5);
    Edge tz = new Edge('t', 'z', -4);
    Edge xt = new Edge('x', 't', -2);
    Edge yz = new Edge('y', 'x', -3);
    Edge zx = new Edge('z', 'x', 7);
    Edge zy = new Edge('z', 'y', 9);
    Edge zs = new Edge('z', 's', 2);
    Edge[] edges = new Edge[]{st, sy, ty, tx, tz, xt, yz, zx, zy, zs};

    // 第一步：初始化距离，初始化原点距离为0
    char[] nodes = new char[]{'s', 't', 'x', 'y', 'z'};
    Map<Character, Integer> distance = new HashMap<>(nodes.length);
    Map<Character, Character> parent = new HashMap<>(nodes.length);
    for (char c : nodes) {
      distance.put(c, Integer.MAX_VALUE);
    }
    distance.put('s', 0);

    // 第二步，松弛(N-1)*E遍
    for (int i = 0; i < nodes.length - 1; i++) {
      for (Edge edge : edges) {
        Integer du = distance.get(edge.u);
        Integer dv = distance.get(edge.v);
        if (du != Integer.MAX_VALUE && dv > du + edge.w) {
          distance.put(edge.v, distance.get(edge.u) + edge.w);
          parent.put(edge.v, edge.u);
        }
      }
    }

    // 第三步
    for (Edge edge : edges) {
      if (distance.get(edge.v) > distance.get(edge.u) + edge.w) {
        System.out.println("有从源点可达的负权回路");
        break;
      }
    }

    for (Map.Entry<Character, Integer> entry : distance.entrySet()) {
      System.out.println(entry.getKey() + "\t" + entry.getValue());
    }

    System.out.println("--------------------------");

    for (Map.Entry<Character, Character> entry : parent.entrySet()) {
      System.out.println(entry.getKey() + "\t" + entry.getValue());
    }
  }
}
