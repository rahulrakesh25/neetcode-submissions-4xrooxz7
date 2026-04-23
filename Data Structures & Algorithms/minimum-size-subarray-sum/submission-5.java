class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, res = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum >= target) {
                res = Math.min(res, (right - left + 1));
            }
            while (sum >= target) {
                sum -= nums[left];
                left++;
                if (sum >= target) {
                    res = Math.min(res, (right - left + 1));
                }
                
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}