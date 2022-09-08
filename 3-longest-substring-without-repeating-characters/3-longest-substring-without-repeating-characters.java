class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, l = 0;
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(map.get(s.charAt(i)) + 1, l);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - l + 1);
        }
        return maxLength;
    }
}