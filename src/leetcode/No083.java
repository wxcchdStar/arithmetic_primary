package leetcode;

/**
 * 删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class No083 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(1);
    head.next = new No092.ListNode(1);
    head.next.next = new No092.ListNode(1);
    head.next.next.next = new No092.ListNode(3);
    head.next.next.next.next = new No092.ListNode(3);
    No092.print(deleteDuplicates(head));
  }

  private static No092.ListNode deleteDuplicates(No092.ListNode head) {
    if (head == null) return head;
    No092.ListNode current = head;

    while (current.next != null) {
      No092.ListNode next = current.next;
      if (next.val == current.val) {
        current.next = next.next;
      } else {
        current = current.next;
      }
    }

    return head;
  }

}
