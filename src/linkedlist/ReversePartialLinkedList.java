package linkedlist;

/*
* 反转部分单向链表
* 反转部分单向链表与反转链表不同的是链表两侧不为NULL，需要将部分链表反转后与原链表重新连接。链表head，起始位置m，终止位置n。
* pre为待反转序列的前一个结点，cur为pre的下一个结点，cur的值自始至终不变，temp为cur的下一个结点。
* 反转过程为将temp从链表中拿下，插入到pre后面，循环n-m次即为所求，类似于头插法反转链表。
* */
public class ReversePartialLinkedList {
    public ListNode reversePartialLinkedList(ListNode head, int m, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int times = n - m;
        while(m > 0){
            pre = pre.next;
            m --;
        }
        ListNode cur = pre.next, temp = null;
        for(int i=0;i<times;i++){
            temp = cur.next;
            cur.next = cur.next.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}