class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int count = 0;
        int l = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) {
                count++;
                if (count > 2) {
                    count++;
                    continue;
                }
                nums[l] = nums[i];
                l++;
            } else if (prev != nums[i]) {
                nums[l] = nums[i];
                l++;
                count = 1;
                prev = nums[i];
            }
            k++;
        }
        return k;
    }
}