class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i : a) {
            rank.putIfAbsent(i, rank.size()+1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}