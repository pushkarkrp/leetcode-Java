class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        if(nums == null || nums.length == 0) return result;
        
        result[0] = 1;
        for (int i = 1; i<nums.length; i++) {
            result[i] = result[i-1] * nums[i-1]; 
        }
        int right = 1;
        for (int j = nums.length-1; j>=0; j--) {
            result[j] *= right; 
            right *= nums[j];
        }
        return result;
    }
}