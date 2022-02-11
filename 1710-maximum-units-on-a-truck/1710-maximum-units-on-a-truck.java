class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        int totalBox = 0;
        for (int[] boxes : boxTypes) {
            if (totalBox + boxes[0] > truckSize) {
                result += (truckSize - totalBox)*boxes[1];
                return result;
            } else {
                totalBox += boxes[0];
                result += boxes[1]*boxes[0];
            }
        }
        return result;
    }
}