package linkedlist;

/*
* 判断链表是否有环
* 利用快慢指针，快指针一次走两步，慢指针一次走一步，如果相遇则返回true
*/
public class HasCycle {
    public boolean hasCycle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}