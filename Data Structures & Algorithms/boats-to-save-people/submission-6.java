class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0, left =0, right = people.length - 1;
        while (left <= right) {
            int remains = limit - people[right];
            right--;
            result++;
            if (left <= right && people[left] <= remains) {
                left++;
            }
        }
        return result;
    }
}
