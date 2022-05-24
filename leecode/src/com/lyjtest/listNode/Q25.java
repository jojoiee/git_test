package com.lyjtest.listNode;

import org.junit.Test;

/**
 * @author NoobProgrammer
 * @title: Q25
 * @projectName leecode
 */
public class Q25 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        Solution solution = new Solution();

        solution.reverseKGroup(list1,2);

    }
}

class Solution {

    @Test
    public void test() {

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = null;
            ListNode temp = slow.next;
            reverseList(slow);
            temp.next = next;
            slow = temp;
            for (int i = 0; i < k - 1; i++) {
                if (fast == null) {
                    break;
                }
                fast = fast.next;
            }

        }
        return dummy.next;

    }

    //把node后面的节点翻转
    private void reverseList(ListNode node) {
        ListNode cur = node.next;
        node.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = next;
        }

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