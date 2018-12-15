package leetcode;

import java.util.List;

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
    ListNode result = swapPairs(head);
    print(result);
  }

  // a -> b -> c -> d
  // c -> d -> a -> b -> e
  private static ListNode swapPairs(ListNode A) {
    ListNode head = null;
    ListNode preNode = null;
    while (A != null && A.next != null) {
      ListNode B = A.next;
      A.next = B.next;
      B.next = A;

      if (preNode != null) {
        preNode.next = B;
      }
      preNode = A;

      if (head == null) {
        head = B;
      }

      A = A.next;
    }

    if (head == null) {
      head = A;
    }
    return head;
  }

  private static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
    System.out.println();
  }
}
