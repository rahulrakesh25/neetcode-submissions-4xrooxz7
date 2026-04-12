class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Arrays.sort(people);
        int result = 0;
        for (int i = 0; i < people.length; i++) {
            int one = i, two = -1;
            if (people[i] != -1) {
                for (int j = i + 1; j < people.length; j++) {
                    if ((people[j] != -1) && (people[i] + people[j] <= limit) && (two == -1 || people[j] > people[two])) {
                        two = j;
                    }
                }
                result++;
                people[one] = -1;
                if (two != -1) {
                    people[two] = -1;
                }
            }
        }
        return result;
    }
}