package leetcode;

/**
 * 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class No061 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(1);
    head.next = new No092.ListNode(2);
    head.next.next = new No092.ListNode(3);
    head.next.next.next = new No092.ListNode(4);
    head.next.next.next.next = new No092.ListNode(5);

    No092.print(rotateRight(head, 2));
  }

  private static No092.ListNode rotateRight(No092.ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    // 计算需要后移几次
    int size = 0;
    No092.ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    k = size - k % size;

    // 后移k次
    temp = head;
    No092.ListNode tail = null;
    int i = 0;
    while (i < k) {
      tail = temp;
      temp = temp.next;
      if (temp == null) {
        temp = head;
      }
      i++;
    }

    // 若后续没有节点，则返回原链表
    if (tail == null || tail.next == null) {
      return head;
    }

    // 组装后移之后的链表
    No092.ListNode tempHead = tail.next;

    No092.ListNode tempNode = tail.next;
    tail.next = null;

    while (tempNode.next != null) {
      tempNode = tempNode.next;
    }
    tempNode.next = head;

    return tempHead;

  }
}
