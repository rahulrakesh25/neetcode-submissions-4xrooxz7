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
            //System.out.println("res -> " + Arrays.toString(res));
            //System.out.println("sums -> " + Arrays.toString(sums));
            //System.out.println("sum " + sum);
            //System.out.println(" left -> " + left + " right -> " + right);
            //System.out.println(" Math.abs(x - arr[right]) -> " + Math.abs(x - arr[right]));

            sums[right] = sums[right - 1] + Math.abs(x - arr[right]);

            //System.out.println("sum " + sum);
            //System.out.println("sums -> " + Arrays.toString(sums));


            int curr = Math.abs(sums[right] - sums[left]);
            //System.out.println("curr " + curr);

            right++;
            left++;

            if (curr < sum) {
                sum = curr;
                res = Arrays.copyOfRange(arr, left, right);
            }

            //System.out.println("res -> " + Arrays.toString(res));

            
        }

        List<Integer> result = new ArrayList<>();
        for (int num : res) {
            result.add(num);
        }
        return result;
    }
}