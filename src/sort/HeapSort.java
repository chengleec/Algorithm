package sort;

public class HeapSort {
    //第一次排序
    public void heapSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int cur = i;
            while(cur != 0){
                int parent = (cur-1)/2;
                if(nums[parent] < nums[cur]){
                    swap(nums,parent,cur);
                    cur = parent;
                }else break;
            }
        }
        for(int i=nums.length-1;i>0;--i){
            swap(nums,0,i);
            //每次排序后调整
            heapify(nums,0,i);
        }
    }
    void heapify(int[] nums, int i, int size){
        int left = i * 2 + 1;
        int right = left + 1;
        int largest = i;
        while(left < size){
            if(nums[left] > nums[largest]) largest = left;
            if(right < size && nums[right] > nums[largest]) largest = right;
            if(largest != i) swap(nums,i,largest);
            else break;
            i = largest;
            left = i * 2 + 1;
            right = left + 1;
        }
    }
    public void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
