
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // max heap → [value, index]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            // add current element
            maxHeap.offer(new int[]{nums[i], i});

            // remove elements outside window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // when window is ready
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}