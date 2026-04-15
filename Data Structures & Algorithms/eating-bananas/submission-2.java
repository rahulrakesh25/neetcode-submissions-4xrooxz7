class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = piles[piles.length - 1];
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hrs = eatHours(piles, mid);
            if (hrs > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
                res = mid;
            }
        }
        return res;
        
    }

    public int eatHours(int [] piles, int rate) {
        long res = 0;
        for (int num : piles) {
            res += (long) Math.ceil((double) num / rate);
        }
        return (int) res;
    }
}
