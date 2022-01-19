class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] freq = new char[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            String key = String.valueOf(freq);
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}