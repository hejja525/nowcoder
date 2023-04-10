package com.hejja.linkedlist;

/**
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class DeleteDuplicates2 {

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
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode newHead = null;
        ListNode node = null;
        while (cur != null) {
            if ((pre == null || cur.val != pre.val) && (cur.next == null || cur.val != cur.next.val)) {
                if (newHead == null) {
                    newHead = cur;
                    node = cur;
                } else {
                    node.next = cur;
                    node = node.next;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        if (node != null) {
            node.next = null;
        }
        return newHead;
    }
}
