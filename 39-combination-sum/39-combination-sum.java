class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findSum(candidates, target, 0, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void findSum(int[] candidates, int target, int current,  List<List<Integer>> result, List<Integer> curList, int index) {
        if (current > target) {
            return;
        }
        if (current == target) {
            result.add(new ArrayList<>(curList));
            return;
        } 
        for (int i = index; i < candidates.length; i++) {
            int val = candidates[i];
            curList.add(val);
            findSum(candidates, target, current + val, result, curList, i);
            curList.remove(curList.size() - 1);
        }
    }
}