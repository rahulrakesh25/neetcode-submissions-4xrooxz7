class Solution {
    public int majorityElement(int[] nums) {
        int num1 = 0, count = 0;
        for (int num : nums) {
            if (num1 == num) {
                count++;
            } else if (count == 0) {
                num1 = num;
                count++;
            } else {
                count--;
            }
        }
        return num1;
    }
}