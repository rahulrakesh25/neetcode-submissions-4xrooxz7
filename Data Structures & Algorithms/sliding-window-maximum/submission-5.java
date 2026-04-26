class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int []> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int [] arr = new int[]{nums[i], i};
            maxHeap.add(arr);
        }

        int left = 0, right = k - 1;
        while (right < nums.length) {
            int [] arr = new int[]{nums[right], right};
            maxHeap.add(arr);
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < left) {
                maxHeap.poll();
            }
            list.add(maxHeap.peek()[0]);
            right++;
            left++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
