class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            if (num % 2 != 0) {
                num *= 2;
            }
            maxHeap.add(num);
            min = Math.min(min, num);
        } 
        while (maxHeap.peek() % 2 == 0) {
            int top = maxHeap.remove();
            result = Math.min(result, top - min);
            min = Math.min(min, top / 2);
            maxHeap.add(top/2);
        }
        return Math.min(result, maxHeap.peek() - min);
    }
}