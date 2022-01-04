class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R') h++;
            else if(ch == 'L') h--;
            else if(ch == 'U') v--;
            else v++;
        }
        if(h == 0 && v == 0) return true;
        return false;
    }
}