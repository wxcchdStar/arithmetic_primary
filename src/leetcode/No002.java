package leetcode;

/**
 * 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author chenhd
 */
public class No002 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode result = addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.print(result.val + " -> ");
      result = result.next;
    }
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode current = null;

    int preState = 0;

    while (l1 != null && l2 != null) {
      int num = l1.val + l2.val + preState;
      preState = num / 10;

      if (current == null) {
        current = new ListNode(num % 10);
        result = current;
      } else {
        current.next = new ListNode(num % 10);
        current = current.next;
      }

      l1 = l1.next;
      l2 = l2.next;
    }

    if (current != null) {
      while (l1 != null) {
        int num = l1.val + preState;
        preState = num / 10;
        current.next = new ListNode(num % 10);
        current = current.next;
        l1 = l1.next;
      }
      while (l2 != null) {
        int num = l2.val + preState;
        preState = num / 10;
        current.next = new ListNode(num % 10);
        current = current.next;
        l2 = l2.next;
      }
      if (preState > 0) {
        current.next = new ListNode(preState);
      }
    }

    return result;
  }

  private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode current = null;

    int preState = 0;

    while (l1 != null || l2 != null) {
      int l1Num = l1 != null ? l1.val : 0;
      int l2Num = l2 != null ? l2.val : 0;
      int num = l1Num + l2Num + preState;
      preState = num / 10;

      if (current == null) {
        current = new ListNode(num % 10);
        result = current;
      } else {
        current.next = new ListNode(num % 10);
        current = current.next;
      }

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }

    if (preState > 0) {
      current.next = new ListNode(preState);
    }

    return result;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
