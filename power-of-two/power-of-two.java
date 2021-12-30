class Solution {
    public boolean isPowerOfTwo(int n) {
        long powTwo = 1;
        while ( powTwo < n) {
            powTwo *= 2;
        }
        return powTwo == n;
    }
}