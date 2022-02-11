class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }
        int l = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
            if (i - l + 1>= s1.length()) {
                if (s1Map.equals(s2Map)) {
                    return true;
                } else {
                    char left = s2.charAt(l);
                    s2Map.put(left, s2Map.getOrDefault(left, 0) - 1);
                    if (s2Map.get(left) == 0) {
                        s2Map.remove(left);
                    }  
                    l = l + 1;
                }
            } 
        }
        return false;
    } 
}