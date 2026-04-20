class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }       

        int partition = (n + m + 1) / 2;

        int left = 0, right = n; // very important
        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = partition - partitionX;

            int l1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int r1 = partitionX == n ? Integer.MAX_VALUE : nums1[partitionX];

            int l2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int r2 = partitionY == m ? Integer.MAX_VALUE : nums2[partitionY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.max(l1, l2);
                }
            }

            if (l1 > r2) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }

        return 0;
        
    }
}