package dp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int maxVal = nums[0], minVal = nums[0], res = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] < 0){
                int tmp = maxVal;
                maxVal = minVal;
                minVal = tmp;
            }
            maxVal = Math.max(maxVal * nums[i], nums[i]);
            minVal = Math.min(minVal * nums[i], nums[i]);
            res = Math.max(maxVal, res);
        }
        return res;
    }
}
