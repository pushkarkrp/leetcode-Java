class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int i : nums) {
            if (mySet.contains(i)) return true;
            mySet.add(i);
        }
        return false;
    }
}