package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
    public static ListNode createLinkedList(){
        ListNode head = new ListNode(1);
        for(int i=9;i>1;i--){
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }
        return head;
    }
    public static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
