package array;

/**
 * @author chenglee
 * @date 2020/6/25 22:22
 * @description
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int maxValue = nums[0], minValue = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){
                int tmp = maxValue;
                maxValue = minValue;
                minValue = tmp;
            }
            maxValue = Math.max(maxValue * nums[i], nums[i]);
            minValue = Math.min(minValue * nums[i], nums[i]);
            res = Math.max(res, maxValue);
        }
        return res;
    }
}
