package linkedlist;
/*
* 删除链表的倒数第K个结点
* */
public class RemoveLastKthNode {
    public ListNode removeLastKthNode(ListNode head, int k){
        ListNode fast = head, slow = head;
        while(k > 0){
            fast = fast.next;
            k --;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}