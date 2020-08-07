package array;

import java.util.Arrays;

/**
 * @author chenglee
 * @date 2020/7/24 10:33
 * @description
 */
/**
 * 算法思想：
 * 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * 在尽可能靠右的低位进行交换，需要从后向前查找
 * 将一个尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
 * 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
 * 以上就是求“下一个排列”的分析过程。
 *
 * 算法过程：
 * 标准的“下一个排列”算法可以描述为：
 * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 * 将 A[i] 与 A[k] 交换
 * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        int i = n - 1, j = n - 1;
        while (i > 0 && nums[i] <= nums[i-1]) i --;
        if (i == 0){
            Arrays.sort(nums);
            return;
        }else {
            while (nums[j] <= nums[i-1]) j --;
            swap(nums,i-1,j);
            Arrays.sort(nums,i,n);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
