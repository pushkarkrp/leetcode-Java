class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int size = (s.length + 1) / 2;
        for (int i = 0; i < size; i++) {
            char temp = s[i];
            s[i] = s[len -1 -i];
            s[len -1 -i] = temp;
        }
    }
}