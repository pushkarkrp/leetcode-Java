class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, min = prices[0];
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(min, price);
        }
        return result;
    }
}