package linkedlist;

/*
* 将两个链表相加求和
* 将两个链表逆序相加，将所得链表反转即为所求
*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        l1 = new ReverseLinkedList().reverseList(l1);
        l2 = new ReverseLinkedList().reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        int val = 0, val1 = 0, val2 = 0;
        while(l1 != null || l2 != null || val != 0){
            val1 = l1 != null ? l1.val : 0;
            val2 = l2 != null ? l2.val : 0;
            val = val1 + val2 + val;

            p.next = new ListNode(val%10);
            p = p.next;
            val /= 10;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return new ReverseLinkedList().reverseList(dummy.next);
    }
}