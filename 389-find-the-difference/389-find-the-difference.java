class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if(map.get(ch) == 0) map.remove(ch);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return '0';
    }
}