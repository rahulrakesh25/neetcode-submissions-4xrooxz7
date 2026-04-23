class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Freq = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Freq.put(ch, s1Freq.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        while (left <= s2.length() - s1.length()) {
            Boolean found = true;
            Map<Character, Integer> currFreq = new HashMap<>();
            for (int i = left; i < left + s1.length(); i++) {
                currFreq.put(s2.charAt(i), currFreq.getOrDefault(s2.charAt(i), 0) + 1);
            }
            for (char ch : s1.toCharArray()) {
                if (currFreq.get(ch) != s1Freq.get(ch)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
            left++;
        }
        return false;
    }
}
