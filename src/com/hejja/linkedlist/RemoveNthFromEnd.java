package com.hejja.linkedlist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 题目保证 n 一定是有效的
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        int length = length(head);
        if (n > length) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        int num = length - n;
        while (--num >= 0) {
            pre = cur;
            cur = cur.next;
        }
        if (pre == null) {
            ListNode next = cur.next;
            cur.next = null;
            return next;
        }
        pre.next = cur.next;
        cur.next = null;
        return head;
    }

    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
