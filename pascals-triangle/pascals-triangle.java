class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) {
            return triangle;
        }
        if(numRows == 1) {
            triangle.add(new ArrayList<>(Arrays.asList(1)));
            return triangle;
        }
        triangle.add(new ArrayList<>(Arrays.asList(1)));
        triangle.add(new ArrayList<>(Arrays.asList(1, 1)));
        List<Integer> temp = triangle.get(1);
        int columns = 2;
        for(int i = 2; i<numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 0; j<i-1; j++) {
                int val = temp.get(j) + temp.get(j+1);
                level.add(val);
            }
            level.add(1);
            triangle.add(level);
            temp = level;
        }
        return triangle;
    }
}