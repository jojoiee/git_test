package com.lyjtest.hot100.question21;

/**
 * @author NoobProgrammer
 * @title: MergeTwoLists
 * @projectName leecode
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @date 2021/12/515:44
 */
public class MergeTwoLists {
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


class Solution {

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //递归退出条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode resNode = new ListNode();

        if ( list1.val < list2.val) {
            resNode.next = mergeTwoLists1(list1.next, list2);
        }

        if ( list1.val > list2.val) {
            resNode.next = mergeTwoLists1(list1, list2.next);
        }

        return resNode;

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resList = new ListNode();
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp3 = resList;
        while (temp1 != null && temp2 != null) {
            //如果链表1的数小，将其加入新链表
//            ListNode temp = Math.min(temp1.val,temp2.val) == temp1.val? temp1:temp2;
            if (temp1.val < temp2.val) {
                ListNode next = temp1.next;
                temp1.next = temp3.next;
                temp3.next = temp1;
                temp3 = temp3.next;
                temp1 = next;
            } else {
                ListNode next = temp2.next;
                temp2.next = temp3.next;
                temp3.next = temp2;
                temp3 = temp3.next;
                temp2 = next;
            }
        }

        //退出循环后将不为空的链表加入新链表
        temp3.next = temp1 == null ? temp2 : temp1;
        return resList;

    }
}