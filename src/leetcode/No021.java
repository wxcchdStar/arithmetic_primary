package leetcode;

/**
 * 合并两个有序链表
 *
 * @author chenhd
 */
public class No021 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode result = mergeTwoLists(l1, l2);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode result = head;

    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        result.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        result.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      result = result.next;
    }
    if (l1 != null) {
      result.next = l1;
    } else if (l2 != null) {
      result.next = l2;
    }
    return head.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
