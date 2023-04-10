package com.hejja.linkedlist;

/**
 * 给定一个链表，请判断该链表是否为回文结构。
 * 回文是指该字符串正序逆序完全一致。
 * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class IsPail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // 双指针
        if (head == null) {
            return true;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode node = reverse(next);
        ListNode cur1 = head;
        ListNode cur2 = node;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 还原
        mid.next = reverse(node);
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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

}
