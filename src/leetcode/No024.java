package leetcode;

/**
 * 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class No024 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    ListNode result = swapPairs2(head);
    print(result);
  }

  // 递归写法
  private static ListNode swapPairs2(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode secondNode = head.next;
    head.next = secondNode.next;
    secondNode.next = head;
    head = secondNode;

    head.next.next = swapPairs2(head.next.next);
    return head;
  }

  // a -> b -> c -> d
  // c -> d -> a -> b -> e
  private static ListNode swapPairs(ListNode head) {
    ListNode result = null;
    ListNode preNode = null;

    while (head != null && head.next != null) {
      ListNode firstNode = head;
      ListNode secondNode = head.next;

      if (preNode == null) {
        preNode = secondNode;
        result = preNode;
      } else {
        preNode.next = secondNode;
      }
      firstNode.next = secondNode.next;
      secondNode.next = firstNode;
      preNode = firstNode;

      head = firstNode.next;
    }

    if (result == null) {
      result = head;
    }

    return result;
  }

  private static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
    System.out.println();
  }
}
