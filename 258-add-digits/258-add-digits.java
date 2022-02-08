class Solution {
    public int addDigits(int num) {
        int result = num;
        while (result / 10 != 0) {
            int rem = 0;
            int quo = result;
            while(quo > 0) {
                rem += quo % 10;
                quo /= 10;
            }
            result = rem;
        }
        return result;
    }
}