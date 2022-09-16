class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }
        int ans =0;
        int size = arr.length/2;
        while(!pq.isEmpty() && size > 0) {
            ans++;
            Map.Entry<Integer, Integer> entry = pq.poll();
            size -= entry.getValue();
        }
        return ans;
    }
}