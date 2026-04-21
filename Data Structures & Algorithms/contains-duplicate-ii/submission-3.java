class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - j > k) {
                window.remove(nums[j]);
                j++;
            }
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
        }
        return false;
    }
}