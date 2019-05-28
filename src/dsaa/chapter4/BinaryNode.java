package dsaa.chapter4;

public class BinaryNode<AnyType> {

  public AnyType element;

  public BinaryNode<AnyType> left;

  public BinaryNode<AnyType> right;

  public int height;

  public BinaryNode(AnyType element) {
    this(element, null, null);
  }

  public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
    this.element = element;
    this.left = left;
    this.right = right;
    this.height = 0;
  }
}
