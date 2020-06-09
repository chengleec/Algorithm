package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenglee
 * @date 2020/5/17 10:32
 * @description
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int cnt = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], cnt);
        }

        List<Integer> list = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(k)
                .map(val -> val.getKey())
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
