package sort;

public class InsertSort {
    public static void insertSort(int[] nums){
        int min = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j] < nums[min]) min = j;
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
            min = i+1;
        }
    }
}
