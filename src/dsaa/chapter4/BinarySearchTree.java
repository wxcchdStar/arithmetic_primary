package dsaa.chapter4;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

  private BinaryNode<AnyType> root;

  public void makeEmpty() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public boolean contains(AnyType x) {
    return contains(root, x);
  }

  public AnyType findMin() {
    BinaryNode<AnyType> node = findMin(root);
    return node != null ? node.element : null;
  }

  public AnyType findMax() {
    BinaryNode<AnyType> node = findMax(root);
    return node != null ? node.element : null;
  }

  public void insert(AnyType x) {
    root = insert(x, root);
  }

  public void remove(AnyType x) {
    root = remove(x, root);
  }

  public void printTree() {

  }

  private boolean contains(BinaryNode<AnyType> root, AnyType x) {
    if (root == null) {
      return false;
    }

    int compareResult = x.compareTo(root.element);
    if (compareResult < 0) {
      return contains(root.left, x);
    } else if (compareResult > 0) {
      return contains(root.right, x);
    }
    return true;
  }

  private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
    if (root == null) {
      return null;
    }
    if (root.left == null) {
      return root;
    }
    return findMin(root.left);
  }

  private BinaryNode<AnyType> findMax(BinaryNode<AnyType> root) {
    if (root == null) {
      return null;
    }
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
    if (t == null) {
      return new BinaryNode<>(x);
    }

    int compareResult = x.compareTo(t.element);
    if (compareResult < 0) {
      t.left = insert(x, t.left);
      if (height(t.left) - height(t.right) == 2) {
        if (x.compareTo(t.left.element) < 0) {
          t = rotateWithLeftChild(t);
        } else {
          t = doubleWithLeftChild(t);
        }
      }
    } else if (compareResult > 0) {
      t.right = insert(x, t.right);
      if (height(t.right) - height(t.left) == 2) {
        if (x.compareTo(t.right.element) > 0) {
          t = rotateWithRightChild(t);
        } else {
          t = doubleWithRightChild(t);
        }
      }
    }
    t.height = Math.max(height(t.left), height(t.right)) + 1;
    return t;
  }

  private BinaryNode<AnyType> doubleWithLeftChild(BinaryNode<AnyType> k3) {
    k3.left = rotateWithRightChild(k3.left);
    return rotateWithLeftChild(k3);
  }

  private BinaryNode<AnyType> doubleWithRightChild(BinaryNode<AnyType> k3) {
    k3.right = rotateWithLeftChild(k3.right);
    return rotateWithRightChild(k3);
  }

  private BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> k2) {
    BinaryNode<AnyType> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;

    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;

    return k1;
  }

  private BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> k2) {
    BinaryNode<AnyType> k1 = k2.right;
    k2.right = k1.left;
    k1.left = k2;

    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;

    return k1;
  }

  private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
    if (t == null) {
      return null;
    }

    int compareResult = x.compareTo(t.element);
    if (compareResult < 0) {
      t.left = remove(x, t.left);
    } else if (compareResult > 0) {
      t.right = remove(x, t.right);
    } else if (t.left != null && t.right != null) {
      t.element = findMin(t.right).element;
      t.right = remove(t.element, t.right);
    } else {
      t = t.left != null ? t.left : t.right;
    }
    return t;
  }

  private int height(BinaryNode<AnyType> t) {
    return t == null ? -1 : t.height;
  }
}
