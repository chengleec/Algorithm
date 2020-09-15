package linkedlist;

/**
 * @author chenglee
 * @date 2020/8/12 16:21
 * @description
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            len ++;
        }
        // 形成一个环
        cur.next = head;
        k = k - k % len;
        while (k != 0){
            cur = cur.next;
            k --;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
