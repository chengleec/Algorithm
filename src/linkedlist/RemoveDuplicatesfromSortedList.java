package linkedlist;

/**
 * @author chenglee
 * @date 2020/6/16 10:53
 * @description
 */
public class RemoveDuplicatesfromSortedList {
    // 如果有重复数字，删除，保留一个
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return head;
        ListNode cur = head;
        while(cur != null &&  cur.next != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
    // 连重复数字本身也删掉
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, cur = head;
        while (cur != null){
            while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
            if (pre.next == cur) pre = pre.next;
            else pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
