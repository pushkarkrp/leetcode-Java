class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        
        for (Character ch : p.toCharArray()) {
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            if(i - l + 1 == p.length()) {
                if(pCount.equals(sCount)) {
                    result.add(l);   
                }
                sCount.put(s.charAt(l), sCount.getOrDefault(s.charAt(l), 0) - 1);
                if(sCount.get(s.charAt(l)) == 0) {
                    sCount.remove(s.charAt(l));
                }
                l++;
            }
        }
        return result;
    }
}