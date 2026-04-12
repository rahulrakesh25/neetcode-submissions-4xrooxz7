class Solution {
    public void rotate(int[] nums, int k) {
        int [] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = ( i + k ) % nums.length;
            arr[index] = nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        
    }
}