class Solution {
    public int triangleNumber(int[] a) {
        Arrays.sort(a);
        int ans = 0;
        for (int k = 2; k < a.length; k++) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (a[i] + a[j] > a[k]) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}