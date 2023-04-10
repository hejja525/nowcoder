package com.hejja.linkedlist;

/**
 * @author hejja
 */
public class AddInList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        AddInList a = new AddInList();
        ListNode reverse = a.reverse(listNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        int length1 = length(head1);
        int length2 = length(head2);

        ListNode l = length1 > length2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode last = curL;
        int carry = 0;
        while (s != null) {
            int sum = s.val + l.val + carry;
            l.val = sum % 10;
            carry = sum / 10;
            s = s.next;
            last = l;
            l = l.next;
        }

        while (l != null) {
            int sum = l.val + carry;
            l.val = sum % 10;
            carry = sum / 10;
            last = l;
            l = l.next;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return reverse(curL);
    }

    // 反转链表
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

    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
