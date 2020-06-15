package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglee
 * @date 2020/6/15 18:27
 * @description
 */
public class Subsets {
    // 无重复元素
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs1(nums,res,list,0);
        return res;
    }
    public void dfs1(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            dfs1(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
    // 有重复元素
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs2(nums,res,list,0);
        return res;
    }
    public void dfs2(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs2(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
