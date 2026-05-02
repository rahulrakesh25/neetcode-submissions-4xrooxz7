/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int index = getMountainIndex(mountainArr);

        int l = 0, r = index;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);

            if (mid == target) {
                return m;
            }

            if (mid > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        l = index; r = mountainArr.length() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);

            if (mid == target) {
                return m;
            }

            if (mid < target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return - 1;

    }
    public static int getMountainIndex(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);
            int left = m == 0 ? mid : mountainArr.get(m - 1);
            int right = m == mountainArr.length() - 1 ? mid : mountainArr.get(m + 1);

            if (mid >= left && mid >= right) {
                return m;
            }

            if (right > mid) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return  l;
    }
}