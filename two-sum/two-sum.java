class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> valByIndex = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            int rem = target - nums[i];
            if (valByIndex.containsKey(rem)) {
                ans[0] = i;
                ans[1] = valByIndex.get(rem);
                return ans;
            } 
            valByIndex.put(nums[i], i);
        }
        return ans;
    }
}