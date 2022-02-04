class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i+j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                result += map.getOrDefault(-1*(i+j), 0);
            }
        }
        return result;
    }
}