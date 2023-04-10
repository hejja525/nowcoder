package com.hejja.linkedlist;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 使用堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = queue.poll();
        if (head != null && head.next != null) {
            queue.offer(head.next);
        }
        ListNode next = head;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            next.next = poll;
            next = next.next;
            if (poll != null && poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return head;
    }
}
