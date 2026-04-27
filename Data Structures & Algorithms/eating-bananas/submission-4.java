class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        int left = 1; // eating rate 0 useless
        int right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // pls use long doing sum -> (pile + mid - 1L)
            long hrs = Arrays.stream(piles).mapToLong(pile -> (pile + mid - 1L) / mid).sum();
            if (hrs > h) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
