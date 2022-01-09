class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if (sum + num > maxSum) maxSum = sum + num;
            sum += num;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}