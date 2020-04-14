package array;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length, l = 0, r = m, lmax = 0, rmin = 0;
        if(m > n) return findMedianSortedArrays(nums2,nums1);

        while (l <= r) {
            int i = (l + r) / 2, j = (m + n + 1) / 2 - i;
            if (i > 0 && nums1[i - 1] > nums2[j])  r = i - 1;
            else if (i < m && nums2[j - 1] > nums1[i]) l = i + 1;
            else {
                if (i == 0) lmax = nums2[j - 1];
                else if (j == 0) rmin = nums1[i - 1];
                else lmax = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return lmax;

                if (i == m) rmin = nums2[j];
                else if (j == n) rmin = nums1[i];
                else rmin = Math.min(nums1[i], nums2[j]);
                return (lmax + rmin) / 2;
            }
        }
        return 0.0;
    }
}
