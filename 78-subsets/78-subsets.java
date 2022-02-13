class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getSubSet(list, nums, 0, new ArrayList<>());    
        return list;
    }
    
    public void getSubSet(List<List<Integer>> list, int[] nums, int index, List<Integer> current) {
        list.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            getSubSet(list, nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}