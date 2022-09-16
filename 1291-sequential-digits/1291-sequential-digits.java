class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sliding = "123456789";
        int l = String.valueOf(low).length();
        int h = String.valueOf(high).length();
        List<Integer> result = new ArrayList<>();
        for (int len = l; len <= h; len++) {
            for (int i = 0; i <= sliding.length() - len; i++) {
                int num = Integer.valueOf(sliding.substring(i, i+len));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}