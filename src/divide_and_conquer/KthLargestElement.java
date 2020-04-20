package divide_and_conquer;

import java.util.Random;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int low, int high, int k) {
        int random = new Random().nextInt(high - low + 1) + low;
        swap(nums,random,high);
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] > nums[high]) {
                swap(nums, index++, i);
            }
        }
        swap(nums,index,high);
        if (index == k - 1) return nums[index];
        if (index >= k - 1) return quickSelect(nums, low, index - 1, k);
        return quickSelect(nums, index + 1, high, k);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
