class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }
            q.offerLast(right);
            if (q.peekFirst() < left) {
                q.pollFirst();
            }
            if (right - left + 1 == k) {
                result[left] = nums[q.peekFirst()];
                left++;
            }
        }

        return result;
    }
}