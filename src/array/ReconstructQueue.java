package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/5/17 10:20
 * @description
 */
public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people)
            res.add(p[1], p);
        return res.toArray(new int[people.length][]);
    }
}
