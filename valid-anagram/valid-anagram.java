class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}