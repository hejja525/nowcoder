package com.hejja.linkedlist;

/**
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=295&tqId=1073463&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class DeleteDuplicates {

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
        int value = head.val;
        ListNode cur = head.next;
        ListNode node = head;
        while (cur != null) {
            if (cur.val != value) {
                node.next = cur;
                node = node.next;
            }
            value = cur.val;
            cur = cur.next;
        }
        node.next = null;
        return head;
    }
}
