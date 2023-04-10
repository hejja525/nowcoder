package com.hejja.linkedlist;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 * @author hejja
 */
public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        // 找到长链表
        int n = 0;
        ListNode cur1 = pHead1;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        ListNode cur2 = pHead2;
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 到最后的节点都不相等，肯定没有相交节点
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? pHead1 : pHead2;
        cur2 = cur1 == pHead1 ? pHead2 : pHead1;
        // 长链表先走n步
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
