package others;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglee
 * @date 2020/5/12 10:39
 * @description
 */
public class SlideWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

        for (int i=0;i<nums.length;i++){
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i])
                q.removeLast();
            while (!q.isEmpty() && i - q.getFirst() + 1 > k)
                q.removeFirst();
            q.offer(i);
            if (!q.isEmpty() && i >= k - 1) list.add(nums[q.getFirst()]);
        }

        int[] res = new int[nums.length - k + 1];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
