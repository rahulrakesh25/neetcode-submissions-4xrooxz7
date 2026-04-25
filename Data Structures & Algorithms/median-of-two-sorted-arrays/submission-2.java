class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0, right = len1;
        int partiton = (len1 + len2) / 2;
        while (left <= right) {
            int partiton1 = left + (right - left) / 2;
            int nums1R = partiton1 == len1 ? Integer.MAX_VALUE : nums1[partiton1];
            int nums1L = partiton1 == 0 ? Integer.MIN_VALUE : nums1[partiton1 - 1];

            int partition2 = partiton - partiton1;
            int nums2R = partition2 == len2 ? Integer.MAX_VALUE : nums2[partition2];
            int nums2L = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 -1];

            if (nums1R >= nums2L && nums2R >= nums1L) {
                if ((len1 + len2) % 2 == 0) {
                    return (double) (Math.max(nums1L, nums2L) + Math.min(nums1R, nums2R)) / 2;
                } else {
                    return (double) Math.min(nums1R, nums2R);
                }
            } else if (nums1R < nums2L) {
                left = partiton1 + 1;
            } else {
                right = partiton1 - 1;
            }
        }
        return (double) 0;
    }
}