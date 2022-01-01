class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >=0 || j >= 0) {
            while (i >= 0 && (skipS > 0 || s.charAt(i) == '#')) {
                if(s.charAt(i) == '#') skipS++;
                else skipS--;
                i--;
            }
            while (j >= 0 && (skipT > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') skipT++;
                else skipT--;
                j--;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }
}