package com.hejja.linkedlist;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class LikedListHasCycle {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode loopNode = getLoopNode(head);
        return loopNode != null;
    }

    public ListNode getLoopNode(ListNode node) {
        // 找环节点，快慢指针
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }
        ListNode slow = node.next;
        ListNode fast = node.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
