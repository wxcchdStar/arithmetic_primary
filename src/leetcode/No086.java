package leetcode;

/**
 * 分隔链表
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class No086 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(1);
    head.next = new No092.ListNode(4);
    head.next.next = new No092.ListNode(3);
    head.next.next.next = new No092.ListNode(2);
    head.next.next.next.next = new No092.ListNode(5);
    head.next.next.next.next.next = new No092.ListNode(2);
    No092.print(partition(head, 3));
  }

  private static No092.ListNode partition(No092.ListNode head, int x) {
    No092.ListNode oddHead = new No092.ListNode(-1);
    No092.ListNode evenHead = new No092.ListNode(-1);
    No092.ListNode odd = oddHead;
    No092.ListNode even = evenHead;

    while (head != null) {
      No092.ListNode next = head.next;
      head.next = null;

      if (head.val < x) {
        odd.next = head;
        odd = odd.next;
      } else {
        even.next = head;
        even = even.next;
      }

      head = next;
    }

    if (evenHead.next != null) {
      odd.next = evenHead.next;
    }
    return oddHead.next;
  }
}
