class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 0 ? -1 : nums[i];
            if(map.containsKey(prefix)) {
               max = Math.max(max, i - map.get(prefix)); 
            }
            map.putIfAbsent(prefix, i);
        }    
        return max;
    }
}