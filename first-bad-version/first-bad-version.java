/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 0, j = n;
        while (i < j) {
            int m = i + (j-i)/2;
            if (!isBadVersion(m)) {
                i = m + 1;
            } else {
                j = m;               
            }
        }
        return i;
    }
}