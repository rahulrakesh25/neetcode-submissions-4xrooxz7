class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int [] sums = new int[arr.length];
        int sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += Math.abs(x - arr[i]);
            sums[i] = sum;
        }

        int start = 0, right = i;
        
        while (right < arr.length) {
            sums[right] = sums[right - 1] + Math.abs(x - arr[right]);
            int curr = Math.abs(sums[right] - sums[right - k]);
            right++;

            if (curr < sum) {
                sum = curr;
                start = right - k;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = start; j < start + k; j++) {
            result.add(arr[j]);
        }
        return result;
    }
}