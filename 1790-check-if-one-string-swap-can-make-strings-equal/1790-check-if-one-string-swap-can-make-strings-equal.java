class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int i1=-1, i2=-1, mismatchCount = 0;
        for (int i = 0; i< s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (i1 != -1 && i2 != -1) {
                    return false;
                } else if (i1 != -1) {
                    i2 = i;
                } else {
                    i1 = i;
                }
            } 
        }
        if (i1 == -1 && i2 == -1) return true;
        if (i1 != -1 && i2 == -1) return false;
        if (s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1)) {
            return true;
        }
        return false;
    }
}