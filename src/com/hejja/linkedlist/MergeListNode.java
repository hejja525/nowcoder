package com.hejja.linkedlist;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tqId=722&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class MergeListNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val >= list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return head;
    }

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
