package leetcode;

/**
 * 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class No023 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {

  }

  private static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    ;
    return mergeKLists2(lists)[0];
  }

  private static ListNode[] mergeKLists2(ListNode[] lists) {
    if (lists.length == 1) {
      return lists;
    }

    ListNode[] result = new ListNode[(lists.length + 1) / 2];

    int start = 0;
    int end = lists.length - 1;

    while (start < end) {
      result[start] = mergeTwoLists(lists[start], lists[end]);
      start++;
      end--;
    }

    if (lists.length % 2 == 1) {
      result[start] = lists[start];
    }

    return mergeKLists2(result);
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

}
