class Solution {
    public int climbStairs(int n) {
        int f = 0, s = 1, ans = 1;
        for (int i = 0; i < n; i++) {
            ans = s + f;
            f = s;
            s = ans;
        }
        return ans;
    }
}