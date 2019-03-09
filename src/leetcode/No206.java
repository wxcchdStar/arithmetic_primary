package leetcode;

/**
 * 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class No206 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

  }

  // a -> b -> c -> d
  private static ListNode reverseList(ListNode head) {
    ListNode result = null;
    while (head != null) {
      ListNode nextNode = head.next;
      head.next = result;
      result = head;
      head = nextNode;
    }
    return result;
  }
}
