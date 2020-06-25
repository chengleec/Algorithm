package array;

public class MedianOfTwoSortedArrays {
    /**
     *      left            right
     * A[0]...A[i-1] | A[i]...A[m-1]
     * B[0]...B[j-1] | B[j]...B[n-1]
     *
     * 要求两个数组的中位数必须满足以下条件：
     * 1. len(left) = len(right) => i + j = m - i + n - j => i ∈ (0,m), j = (m + n + 1) / 2 - i
     *  (1) 如果 m + n 是偶数，i + j == m - i + n - j
     *  (2) 如果 m + n 是奇数, left 会比 right 多一个元素，i + j == m - i + n - j + 1
     * 2. A[i-1] <= B[j] && B[j-1] <= A[i]
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = 0, r = m, lmax = 0, rmin = 0;
        if (m > n) return findMedianSortedArrays(nums2,nums1);

        while (l <= r){
            int i = (l + r)/2, j = (m + n + 1)/2 - i;
            if (i > 0 && nums1[i-1] > nums2[j]){
                r = i - 1;
            }else if (i < m && nums2[j-1] > nums1[i]){
                l = i + 1;
            }else {
                lmax = i == 0 ? nums2[j-1] : (j == 0 ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1]));
                // 如果 m + n 是奇数，直接返回 left 的最大值
                if (((m + n) & 1) == 1) return lmax;
                rmin = i == m ? nums2[j] : (j == n ? nums1[i] : Math.min(nums1[i], nums2[j]));
                return 0.5 * (lmax + rmin);
            }
        }
        return 0.0;
    }

}
