package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class No082 {

  public static void main(String[] args) {
    No092.ListNode head = new No092.ListNode(1);
    head.next = new No092.ListNode(2);
    head.next.next = new No092.ListNode(2);
    head.next.next.next = new No092.ListNode(2);
    head.next.next.next.next = new No092.ListNode(3);
    No092.print(deleteDuplicates2(head));
  }

  private static No092.ListNode deleteDuplicates(No092.ListNode head) {
    if (head == null) return head;

    Set<Integer> set = new HashSet<>();

    No092.ListNode newHead = new No092.ListNode(-1);
    No092.ListNode current = newHead;

    while (head.next != null) {
      No092.ListNode next = head.next;
      head.next = null;

      if (head.val != next.val && !set.contains(head.val)) {
        current.next = head;
        current = current.next;
      } else {
        set.add(head.val);
      }

      head = next;
    }

    if (!set.contains(head.val)) {
      current.next = head;
    }

    return newHead.next;
  }

  private static No092.ListNode deleteDuplicates2(No092.ListNode head) {
    if (head == null) return head;

    No092.ListNode newHead = new No092.ListNode(-1);
    No092.ListNode current = newHead;
    No092.ListNode same = null;

    while (head.next != null) {
      No092.ListNode next = head.next;
      head.next = null;

      if (head.val != next.val && (same == null || head.val != same.val)) {
        current.next = head;
        current = current.next;
      } else {
        same = head;
      }

      head = next;
    }

    if (head.val != current.val && (same == null || head.val != same.val)) {
      current.next = head;
    }

    return newHead.next;
  }

}
