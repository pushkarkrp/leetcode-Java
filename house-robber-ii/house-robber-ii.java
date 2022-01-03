class Solution {
    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int s, int e) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int h1 = nums[s];
        int h2 = Math.max(nums[s+1], nums[s]);
        for (int i = s+2; i<e; i++) {
            int temp = Math.max(h1 + nums[i], h2);
            h1 = h2;
            h2 = temp;
        }
        return h2;
    }
}