class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = k;
        List<Integer> res = new ArrayList<>();
        while (right <= nums.length) {
            int [] arr = Arrays.copyOfRange(nums, left, right);
            Arrays.sort(arr);
            res.add(arr[arr.length - 1]);
            left++;
            right++;
        }
        int[] primitiveArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            primitiveArray[i] = res.get(i);
        }
        return primitiveArray;
    }
}