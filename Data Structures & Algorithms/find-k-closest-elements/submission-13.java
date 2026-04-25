class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int [] sums = new int[arr.length];
        int sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += Math.abs(x - arr[i]);
            sums[i] = sum;
        }

        int left = 0, right = i;
        int [] res = Arrays.copyOfRange(arr, left, right);
        
        while (right < arr.length) {
            sums[right] = sums[right - 1] + Math.abs(x - arr[right]);
            int curr = Math.abs(sums[right] - sums[left]);
            right++;
            left++;

            if (curr < sum) {
                sum = curr;
                res = Arrays.copyOfRange(arr, left, right);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : res) {
            result.add(num);
        }
        return result;
    }
}