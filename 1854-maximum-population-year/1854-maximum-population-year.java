class Solution {
    public int maximumPopulation(int[][] logs) {
        if(logs.length == 0) return 0;
        int[] popu = new int[2051];
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] log : logs) {
            popu[log[0]]++;
            popu[log[1]]--;
        }
        
        for (int i = 1; i < popu.length; i++) {
            popu[i] += popu[i-1];
            if (max < popu[i]) {
                ans = i;
                max = popu[i];
            }
        }
        return ans;
    }
}