package com.hejja.linkedlist;

/**
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 * https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class SortInList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // 使用归并排序
        return process(head);
    }

    public ListNode process(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中点位置
        ListNode mid = getMid(head);
        // 断开链表
        ListNode next = mid.next;
        mid.next = null;
        // 左边有序
        ListNode left = process(head);
        // 右边有序
        ListNode right = process(next);
        // 整体有序
        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur;
        if (head1.val > head2.val) {
            cur = head2;
            head2 = head2.next;
        } else {
            cur = head1;
            head1 = head1.next;
        }
        ListNode head = cur;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        if (head1 == null) {
            cur.next = head2;
        }
        if (head2 == null) {
            cur.next = head1;
        }
        return head;
    }
}
