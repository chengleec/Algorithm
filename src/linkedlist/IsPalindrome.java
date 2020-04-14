package linkedlist;

import java.util.Stack;

/*
* 判断一个链表是否是回文结构
* 利用一个栈结构，将链表右半部分按顺序入栈，弹出顺序应与链表左半部分相同
*/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        //slow一次走一步，fast一次走两步，当fast走到末尾时，slow为中间位置
        ListNode slow = head.next, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.empty()) {
            if (head.val != stack.peek().val) return false;
            else {
                stack.pop();
                head = head.next;
            }
        }
        return true;
    }
}
