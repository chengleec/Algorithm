package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/15 19:04
 * @description
 */
public class Permutations {
    // 无重复元素
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs1(nums,res,list);
        return res;
    }
    public void dfs1(int[] nums, List<List<Integer>> res, List<Integer> list){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs1(nums,res,list);
            list.remove(list.size()-1);
        }
    }
    // 有重复元素
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(nums,res,list,used);
        return res;
    }
    public void dfs2(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs2(nums,res,list,used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
