package com.lyjtest.hot100.question19;

import java.util.List;
import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: RemoveNthFromEnd
 * @projectName leecode
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @date 2021/12/714:59
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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


class Solution {
    //添加一个哑节点（dummy node），它的next 指针指向链表的头节点。
    // 这样一来，我们就不需要对头节点进行特殊的判断了。

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //数据校验
        if (head.next == null) {
            return null;
        }
        //遍历链表得到长度
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        //要指向待删除结点的前一个结点
        int target = length - n;
        //如果待删除的是头节点
        if (target == 0) {
            head = head.next;
            return head;
        }
        //指向待删除结点的前一个结点
        ListNode before = head;
        while (true) {
//            target--;
//            before = before.next;
            target--;
            if (target <= 0 || before == null) {
                break;
            }
            before = before.next;
        }
        //before指向了待删除结点的前一个结点

        if (before != null) {
            before.next = before.next.next;
            return head;
        } else {
            return null;
        }


    }

    //使用栈
    public ListNode removeNthFromEndMethod2(ListNode head, int n) {
        //创建一个哑节点对象
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        Stack<ListNode> nodeStack = new Stack<>();
        //将链表中的元素入栈
        ListNode cur = dummyNode;
        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.next;
        }

        //pop出后面n个节点
        for (int i = 0; i < n; i++) {
            nodeStack.pop();
        }
        //待删除结点的前一个结点
        ListNode prev = nodeStack.peek();

        prev.next = prev.next.next;
        return dummyNode.next;
    }

    //使用快慢指针 ：
    //first指针比second指针领先n个节点：当first指针指向末尾时，second指针指向倒数第n个的前一个
    public ListNode removeNthFromEndMethod3(ListNode head, int n) {
        //创建一个哑节点对象，使得不需要考虑改变头指针的特殊情况
        //直接返回 哑节点.next 即可
        ListNode dummyNode = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummyNode;
        //开始时first指针与second指针都在0处，当first走到第n个指针后second开始行动
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //此时second开始移动
        while (first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}