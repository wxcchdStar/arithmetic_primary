package leetcode;

/**
 * k个一组翻转链表
 * <p>
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class No025 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
//    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);
    print(reverseKGroup(head, 4));
  }

  private static ListNode reverseKGroup(ListNode head, int k) {
    ListNode newHead = null;

    ListNode prefixNode = null;
    ListNode suffixNode = null;

    ListNode temp = null;

    int start = 1;
    int m = 1;
    int n = k;
    while (head != null && start >= m && start <= n) {
      if (suffixNode == null) {
        suffixNode = head;
      }

      ListNode next = head.next;
      head.next = temp;
      temp = head;
      head = next;

      if (start == n) {
        if (prefixNode != null) {
          prefixNode.next = temp;
        } else {
          newHead = temp;
        }
        suffixNode.next = head;
        // 下一次反转的前缀就是上一次反转的后缀
        prefixNode = suffixNode;
        suffixNode = null;
        temp = null;
        m = start + 1;
        n = m + k - 1;
      }
      start++;
    }

    ListNode newList = null;
    while (temp != null) {
      ListNode next = temp.next;

      temp.next = newList;
      newList = temp;

      temp = next;
    }

    if (prefixNode != null) {
      prefixNode.next = newList;
    }
    if (newHead == null) {
      newHead = newList;
    }
    return newHead;
  }

  private static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
    System.out.println();
  }
}
