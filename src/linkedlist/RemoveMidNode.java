package linkedlist;

/*
* 删除链表的中间结点
* */
public class RemoveMidNode {
    public ListNode removeMidNode(ListNode head){
        if(head == null || head.next == null) return head;
        if(head.next.next == null) return head.next;

        ListNode fast = head.next.next, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
