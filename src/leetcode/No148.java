package leetcode;

/**
 * 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class No148 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(4);
    head.next = new No092.ListNode(2);
    head.next.next = new No092.ListNode(1);
    head.next.next.next = new No092.ListNode(3);
    No092.print(sortList(head));
  }

  private static No092.ListNode sortList(No092.ListNode head) {
    No092.ListNode prev = null;
    No092.ListNode slow = head;
    No092.ListNode fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (prev != null) {
      prev.next = null;
    }

    if (head != slow) {
      No092.ListNode l1 = sortList(head);
      No092.ListNode l2 = sortList(slow);

      return merge(l1, l2);
    } else {
      return head;
    }
  }

  private static No092.ListNode merge(No092.ListNode l1, No092.ListNode l2) {
    No092.ListNode l = new No092.ListNode(0), p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null) {
      p.next = l1;
    }

    if (l2 != null) {
      p.next = l2;
    }

    return l.next;
  }
}
