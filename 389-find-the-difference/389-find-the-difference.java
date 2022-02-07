class Solution {
    public char findTheDifference(String s, String t) {
        char result = t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            result ^= s.charAt(i-1);
            result ^= t.charAt(i);
        }
        return result;
    }
}