class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.equals("")) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            sMap.put(ch, 0);
        }

        int have = 0, need = tMap.size();
        int left = 0;
        int start = 0, len = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char sChar = s.charAt(right);

            if (tMap.containsKey(sChar)) {
                sMap.put(sChar, sMap.get(sChar) + 1);

                if (sMap.get(sChar).intValue() == tMap.get(sChar).intValue()) {
                    have++;
                }
            }

            while (have == need) {
                if ((right - left + 1) < len) {
                    len = right - left + 1;
                    start = left;
                }

                char curr = s.charAt(left);

                if (tMap.containsKey(curr)) {
                    sMap.put(curr, sMap.get(curr) - 1);

                    if (sMap.get(curr) < tMap.get(curr)) {
                        have--;
                    }
                }

                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}