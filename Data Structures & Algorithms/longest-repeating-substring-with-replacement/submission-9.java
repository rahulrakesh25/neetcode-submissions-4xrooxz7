class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            System.out.println("max value -> " + (i + 1) + " " + Collections.max(map.values()));

            while((i - l + 1 - Collections.max(map.values())) > k) {
                System.out.println("max value 2 -> " + (i - l + 1) + " " + Collections.max(map.values()));
                System.out.println(" l -> " + l);
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, (i - l + 1));
        }
        return res;
    }
}
