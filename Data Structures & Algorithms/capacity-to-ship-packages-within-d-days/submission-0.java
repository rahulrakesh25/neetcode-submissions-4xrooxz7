class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Integer.MAX_VALUE;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int doneDays = getDays(weights, mid);
            System.out.println("days " + doneDays + " mid " + mid);
            if (doneDays > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
        
    }

    public int getDays(int [] weights, int capacity) {
        int days = 1;
        int cap = capacity;
        for (int i = 0; i < weights.length; ) {
            if (cap - weights[i] >= 0) {
                cap -= weights[i];
                i++;
            } else {
                cap = capacity;
                days++;
            }
        }
        return days;
    }
}