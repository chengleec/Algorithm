package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/15 19:31
 * @description
 */
public class CombinationSum {
    // 无重复元素，且每个元素可以使用多次
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs1(candidates,res,list,target,0);
        return res;
    }
    public void dfs1(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int start){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs1(candidates,res,list,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
    // 有重复元素，且每个元素只能使用 1 次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(candidates,res,list,target,0);
        return res;
    }
    public void dfs2(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int start){
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs2(candidates,res,list,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
