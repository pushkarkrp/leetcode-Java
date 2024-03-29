class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        int max = Collections.max(count.values());
        for (int key : count.keySet()) {
            if (count.get(key) == max) {
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }
}