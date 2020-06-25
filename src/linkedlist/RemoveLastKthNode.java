package linkedlist;
/*
* 删除链表的倒数第K个结点
* */
public class RemoveLastKthNode {
    public ListNode removeLastKthNode(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (n > 0){
            fast = fast.next;
            n --;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}