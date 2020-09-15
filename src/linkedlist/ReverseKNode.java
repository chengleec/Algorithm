package linkedlist;

/*
* 将单链表每K个结点逆序
* K个结点一组，每组内按照反转部分链表进行逆序，若最后结点不足K个，则不反转
*/
public class ReverseKNode {
    public ListNode reverseKNode(ListNode head, int k){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int cnt = 1;
        ListNode pre = dummy;
        while(head != null){
            if(cnt == k){
                ListNode cur = pre.next, temp = null;
                for (int i = 1; i < k; i++) {
                    temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = pre.next;
                    pre.next = temp;
                }
                pre = cur;
                head = cur;
                cnt = 0;
            }
            cnt ++;
            head = head.next;
        }
        return dummy.next;
    }
}