package com.hejja.linkedlist;

/**
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 * https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=295&tqId=1073463&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class OddEvenList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int num = 3;
        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        head = head.next.next;
        while (head != null) {
            if ((num & 1) == 0) {
                // 偶数
                even.next = head;
                even = even.next;
            } else {
                // 奇数
                odd.next = head;
                odd = odd.next;
            }
            num++;
            head = head.next;
        }
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }
}
