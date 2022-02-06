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
                    continue;
                }
                nums[l] = nums[i];
            } else if (prev != nums[i]) {
                nums[l] = nums[i];
                count = 1;
                prev = nums[i];
            }
            l++;
            k++;
        }
        return k;
    }
}