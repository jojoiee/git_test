package com.lyjtest.hot100;

/**
 * @author NoobProgrammer
 * @title: TwoNumSum
 * @projectName leecode
 * @description: 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * @date 2021/12/2 12:06
 */
public class TwoNumSum {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        //   ListNode node5 = new ListNode(3);
        ListNode head2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        head1.next = node1;
        node1.next = node2;
//        node2.next = node5;
        head2.next = node3;
        node3.next = node4;
        ListNode temp = addTwoNumbers1(head1, head2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;//表示进位值
        int res = 0;
        ListNode resHead = null;
        ListNode temp = null; //指向resHead头指针
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            res = n1 + n2 + carry;
            carry = res / 10;

            if (resHead == null) {
                resHead = new ListNode(res % 10);
                temp = resHead;
            } else {
                temp.next = new ListNode(res % 10);
                temp = temp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry != 0){
            temp.next = new ListNode(1);
        }
        //退出循环说明有一个链表已经遍历到最后
        return resHead;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode resList = null;//保存最后结果的链表
        boolean flag = false; //标志是否进位

        int res = temp1.val + temp2.val;
        if (res >= 10) {
            resList = new ListNode(res % 10);
            flag = true;
        } else {
            resList = new ListNode(res);
            flag = false;
        }
        temp1 = temp1.next;
        temp2 = temp2.next;
        //辅助指针指向结果链表的头节点
        ListNode temp3 = resList;
        while (temp1 != null && temp2 != null) {
            if (flag) {
                res = temp1.val + temp2.val + 1;
            } else {
                res = temp1.val + temp2.val;
            }
            if (res >= 10) {
                temp3.next = new ListNode(res % 10);
                flag = true;
            } else {
                temp3.next = new ListNode(res);
                flag = false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }
        //如果有个链表更长
        ListNode longTemp = temp1 == null ? temp2 : temp1;
        //将这个链表添加到结果链表后面
        while (longTemp != null) {
            if (flag) {
                res = longTemp.val + 1;
            } else {
                res = longTemp.val;
            }
            if (res >= 10) {
                temp3.next = new ListNode(res % 10);
                flag = true;
            } else {
                temp3.next = new ListNode(res);
                flag = false;
            }
            longTemp = longTemp.next;
            temp3 = temp3.next;
        }
        if (flag) {
            temp3.next = new ListNode(1);
        }

        return resList;

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
