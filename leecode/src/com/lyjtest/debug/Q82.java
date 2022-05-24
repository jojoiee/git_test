package com.lyjtest.debug;

import org.junit.Test;

/**
 * @author NoobProgrammer
 * @title: Q82
 * @projectName leecode
 */
public class Q82 {

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(1));
        deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode next = cur;
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummy.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
