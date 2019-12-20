package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. 克隆图
 * <p>
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clone-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No133 {


  public static void main(String[] args) {
    Node node1 = new Node();
    node1.val = 1;
    node1.neighbors = new ArrayList<>();

    Node node2 = new Node();
    node2.val = 2;
    node2.neighbors = new ArrayList<>();

    Node node3 = new Node();
    node3.val = 3;
    node3.neighbors = new ArrayList<>();

    Node node4 = new Node();
    node4.val = 2;
    node4.neighbors = new ArrayList<>();

    node1.neighbors.add(node2);
    node1.neighbors.add(node4);

    node2.neighbors.add(node1);
    node2.neighbors.add(node3);

    node3.neighbors.add(node2);
    node3.neighbors.add(node4);

    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    new No133().cloneGraph(node1);
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> map = new HashMap<>();
    return test(node, map);
  }

  private Node test(Node node, Map<Integer, Node> map) {
    if (map.containsKey(node.val)) {
      return map.get(node.val);
    }
    Node n = new Node();
    n.val = node.val;
    n.neighbors = new ArrayList<>();
    map.put(node.val, n);
    for (Node temp : node.neighbors) {
      n.neighbors.add(test(temp, map));
    }
    return n;
  }

  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

}
