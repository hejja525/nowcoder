package com.hejja.linkedlist;

/**
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 *
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=295&tqId=722&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
 *
 * @author hejja
 */
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        reverse(start, end);
        head = end;
        ListNode lastEnd = start;
        while (lastEnd != null) {
            start = lastEnd.next;
            end = getGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public ListNode getGroupEnd(ListNode node, int k) {
        while (--k != 0 && node != null) {
            node = node.next;
        }
        return node;
    }

    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode head = start;
        ListNode pre = null;
        ListNode next = null;
        while (start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        head.next = end;
    }
}
