class Solution {
    public boolean validPalindrome(String s) {
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isPalindrome(chars, i)) {
                return true;
            }
        }
        return false;
    }
    public boolean isPalindrome(char [] chars, int n) {
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (i == n) {
                i++;
            } else if (j == n) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}