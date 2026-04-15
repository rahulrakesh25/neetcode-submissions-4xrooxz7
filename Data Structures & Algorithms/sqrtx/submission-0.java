class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid > x) {
                high = mid - 1;
            } else if ((long) mid * mid < x) {
                low = mid + 1;
                res = mid;
            } else {
                return mid;
            }
        }

        return res;
    }
}