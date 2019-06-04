package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieTree {

  private static class Node {
    char value;
    boolean end;
    Map<Character, Node> nexts = new HashMap<>();

    public Node(char value, boolean end) {
      this.value = value;
      this.end = end;
    }
  }

  private Node root;

  public TrieTree() {
    root = new Node('/', false);
  }

  public void insert(String word) {
    if (word == null) {
      return;
    }
    insert(root, word, 0);
  }

  private void insert(Node node, String word, int i) {
    if (i >= word.length()) {
      return;
    }

    char value = word.charAt(i);
    Node next = node.nexts.get(value);
    if (next == null) {
      next = new Node(value,i == word.length() - 1);
      node.nexts.put(value, next);
    }
    if (!next.end) {
      next.end = i == word.length() - 1;
    }
    insert(next, word, i + 1);
  }

  public boolean search(String word) {
    if (word == null) {
      return false;
    }
    return search(root, word, 0, false);
  }

  private boolean search(Node root, String word, int i, boolean isPrefix) {
    if (i >= word.length()) {
      return isPrefix || root.end;
    }

    char c = word.charAt(i);
    if (root.nexts.containsKey(c)) {
      return search(root.nexts.get(c), word, i + 1, isPrefix);
    }
    return false;
  }

  public boolean startsWith(String prefix) {
    if (prefix == null) {
      return false;
    }

    return search(root, prefix, 0, true);
  }

  public void delete(String word) {
    if (word == null) {
      return;
    }

    List<Node> nodeList = new ArrayList<>();
    nodeList.add(root);

    Node node = root;
    for (char c : word.toCharArray()) {
      node = node.nexts.get(c);
      if (node != null) {
        nodeList.add(node);
      } else {
        return;
      }
    }

    if (nodeList.get(nodeList.size() - 1).end) {
      for (int i = nodeList.size() - 1; i > 0; i--) {
        Node aNode = nodeList.get(i);
        if (aNode.nexts.isEmpty()) {
          nodeList.get(i - 1).nexts.remove(aNode.value);
        } else {
          aNode.end = false;
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    TrieTree trie = new TrieTree();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
    trie.delete("app");
    System.out.println(trie.search("app"));
    System.out.println(trie.search("apple"));

  }
}
