package leetcode;

/**
 * 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class No092 {

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

    print(reverseBetween(head, 2, 4));
  }

  // a -> b -> c -> d
  private static ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode newHead = null;

    ListNode prefixNode = null;
    ListNode suffixNode = null;

    ListNode temp = null;

    int start = 1;
    while (head != null) {
      if (start < m) {
        if (newHead == null) {
          newHead = head;
        }
        prefixNode = head;
        head = head.next;
      } else if (start >= m && start <= n) {
        if (suffixNode == null) {
          suffixNode = head;
        }

        ListNode next = head.next;

        head.next = temp;
        temp = head;

        head = next;
      } else {
        break;
      }
      start++;
    }

    if (prefixNode != null) {
      prefixNode.next = temp;
    } else {
      newHead = temp;
    }
    suffixNode.next = head;

    return newHead;
  }

  public static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
    System.out.println();
  }
}
