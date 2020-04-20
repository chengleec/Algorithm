package sort;

import java.util.Random;

public class QuickSort {
    public void quickSort1(int[] nums, int start, int end){
        if(start > end) return;
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums,random,start);
        int index = start, i = start, j = end;
        while(i < j){
            while (i < j && nums[j] >= nums[index]) j --;
            while (i < j && nums[i] < nums[index]) i ++;
            swap(nums, i, j);
        }
        swap(nums, i, index);
        quickSort1(nums,start,i-1);
        quickSort1(nums,i+1,end);
    }
    public void quickSort2(int[] nums, int start, int end){
        if(start > end) return;
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums,random,end);
        int index = start;
        for(int i=start; i<end; i++){
            if(nums[i] <= nums[end]) swap(nums,i,index++);
        }
        swap(nums,index,end);
        quickSort2(nums, start,index-1);
        quickSort2(nums,index+1, end);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
