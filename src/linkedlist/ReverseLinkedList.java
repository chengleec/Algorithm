package linkedlist;

/*
* 反转单向链表
* */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}