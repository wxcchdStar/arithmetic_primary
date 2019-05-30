package leetcode;

/**
 * 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class No328 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(1);
    head.next = new No092.ListNode(2);
//    head.next.next = new No092.ListNode(3);
//    head.next.next.next = new No092.ListNode(4);
//    head.next.next.next.next = new No092.ListNode(5);
    No092.print(oddEvenList(head));
  }

  private static No092.ListNode oddEvenList(No092.ListNode head) {
    No092.ListNode oddHead = new No092.ListNode(-1);
    No092.ListNode evenHead = new No092.ListNode(-1);
    No092.ListNode odd = oddHead;
    No092.ListNode even = evenHead;

    int count = 1;
    while (head != null) {
      No092.ListNode next = head.next;
      head.next = null;

      if (count % 2 == 1) {
        odd.next = head;
        odd = odd.next;
      } else {
        even.next = head;
        even = even.next;
      }

      head = next;
      count++;
    }

    if (evenHead.next != null) {
      odd.next = evenHead.next;
    }
    return oddHead.next;
  }
}
