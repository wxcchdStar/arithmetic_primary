package dsaa.chapter4;

public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {

  private RedBlackNode<AnyType> root;

  // 左旋
  private void rotateWithRightChild(RedBlackNode<AnyType> x) {
    RedBlackNode<AnyType> y = x.right;
    // 将y的左子树放到x的右子树上
    x.right = y.left;
    y.left.parent = x;
    // 将y放到x的父节点的子节点上
    y.parent = x.parent;
    if (x.parent == null) {
      root = y;
    } else if (x.parent.left == x) {
      x.parent.left = y;
    } else if (x.parent.right == x) {
      x.parent.right = y;
    }
    // 将x放到y的左子树上
    y.left = x;
    x.parent = y;
  }

  // 右旋
  private void rotateWithLeftChild(RedBlackNode<AnyType> x) {
    RedBlackNode<AnyType> y = x.left;
    // 将y的右子树放到x的左子树上
    x.left = y.right;
    y.right.parent = x;
    // 将y放到x的父节点的子节点上
    y.parent = x.parent;
    if (x.parent == null) {
      root = y;
    } else if (x.parent.left == x) {
      x.parent.left = y;
    } else if (x.parent.right == x) {
      x.parent.right = y;
    }
    // 将x放到y的右子树上
    y.right = x;
    x.parent = y;
  }

  public void insert(RedBlackNode<AnyType> z) {
    // 使用双指针查找待插入节点y
    RedBlackNode<AnyType> y = null;
    RedBlackNode<AnyType> x = root;
    while (x != null) {
      y = x;
      if (z.element.compareTo(x.element) < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }
    // 插入
    z.parent = y;
    if (y == null) {
      root = z;
    } else if (z.element.compareTo(y.element) < 0) {
      y.left = z;
    } else {
      y.right = z;
    }
    z.red = true;
    insertFixColor(z);
  }

  private void insertFixColor(RedBlackNode<AnyType> z) {
    while (z.parent != null && z.parent.red) {
      if (z.parent == z.parent.parent.left) {
        RedBlackNode<AnyType> y = z.parent.parent.right;
        if (y.red) {
          // 叔叔节点是红色（父节点是红色），直接颜色重置也可
          z.parent.red = false;
          y.red = false;
          z.parent.parent.red = true;
          z = z.parent.parent;
        } else {
          // 叔叔节点是黑色（父节点是红色），先左旋再右旋（跟）
          if (z == z.parent.right) {
            z = z.parent;
            rotateWithRightChild(z);
          }
          z.parent.red = false;
          z.parent.parent.red = true;
          rotateWithLeftChild(z.parent.parent);
        }
      } else {
        // 对称
        RedBlackNode<AnyType> y = z.parent.parent.left;
        if (y.red) {
          z.parent.red = false;
          y.red = false;
          z.parent.parent.red = true;
          z = z.parent.parent;
        } else {
          if (z == z.parent.left) {
            z = z.parent;
            rotateWithLeftChild(z);
          }
          z.parent.red = false;
          z.parent.parent.red = true;
          rotateWithRightChild(z.parent.parent);
        }
      }
    }
    root.red = false;
  }

  // 取决于有几个子节点
  public RedBlackNode<AnyType> delete(RedBlackNode<AnyType> z) {
    // 确定要删除的节点y
    RedBlackNode<AnyType> y;
    if (z.left == null || z.right == null) {
      y = z;
    } else {
      //后继节点一定没有左子节点
      y = successor(z);
    }
    // y的父节点连接y的单个子节点【parent部分
    RedBlackNode<AnyType> x; //x只会是一个子节点或者null
    if (y.left != null) {
      x = y.left;
    } else {
      x = y.right;
    }
    if (x != null) {
      x.parent = y.parent;
    }
    // y的父节点连接y的单个子节点【child部分】
    if (y.parent == null) {
      root = x;
    } else if (y == y.parent.left) {
      y.parent.left = x;
    } else {
      y.parent.right = x;
    }
    if (y.element.compareTo(z.element) != 0) {
      z.element = y.element;
    }
    if (!y.red) {
      // 只有删除黑色节点时才会破坏红黑树
      deleteFix(x);
    }
    return y;
  }

  private void deleteFix(RedBlackNode<AnyType> x) {
    while (x != root && !x.red) {
      if (x == x.parent.left) {
        RedBlackNode<AnyType> w = x.parent.right;
        if (w.red) {
          // case1, 兄弟节点是红色（x自己是黑色），则左旋
          w.red = false;
          x.parent.red = true;
          rotateWithRightChild(x.parent);
          w = x.parent.right;
          if (!w.left.red && !w.right.red) {
            // case2，兄弟节点是黑色，兄弟节点的两个子节点都是黑色，则让兄弟节点变为红色
            w.red = true;
            x = x.parent;
          } else {
            // case3，兄弟节点是黑色，兄弟节点的右子节点是黑色（两一个子节点是红色），则交换左子节点和兄弟节点的颜色并右旋
            if (!w.right.red) {
              w.left.red = false;
              w.red = true;
              rotateWithLeftChild(w);
              w = x.parent.right;
            }
            // case4，兄弟节点是黑色，，兄弟节点的右子节点是红色，则将w置为父节点颜色，父节点及w右子节点置为黑色，最后左旋x的父节点
            w.red = x.parent.red;
            x.parent.red = false;
            w.right.red = false;
            rotateWithRightChild(x.parent);
            x = root;
          }
        }
      } else {
        RedBlackNode<AnyType> w = x.parent.left;
        if (w.red) {
          // case1
          w.red = false;
          x.parent.red = true;
          rotateWithLeftChild(x.parent);
          w = x.parent.left;
          if (!w.left.red && !w.right.red) {
            // case2
            w.red = true;
            x = x.parent;
          } else {
            // case3
            if (!w.left.red) {
              w.right.red = false;
              w.red = true;
              rotateWithRightChild(w);
              w = x.parent.left;
            }
            // case4
            w.red = x.parent.red;
            x.parent.red = false;
            w.right.red = false;
            rotateWithLeftChild(x.parent);
            x = root;
          }
        }
      }
    }
    x.red = false;
  }

  private RedBlackNode<AnyType> successor(RedBlackNode<AnyType> x) {
    if (x.right != null) {
      // 右子树非空，则为右子树的最左节点
      return findMin(x);
    }
    // 右子树为空，则向上查找直到遇到某个是其父节点的左节点为止。
    RedBlackNode<AnyType> y = x.parent;
    while (y != null && x == y.right) {
      x = y;
      y = y.parent;
    }
    return y;
  }

  public RedBlackNode<AnyType> findMin(RedBlackNode<AnyType> z) {
    while (z.left != null) {
      z = z.left;
    }
    return z;
  }
}
