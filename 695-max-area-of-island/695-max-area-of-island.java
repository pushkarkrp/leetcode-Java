class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid)); 
                }
            }
        }
        return ans;
    }
    public int dfs (int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int sum = 1;
        grid[i][j] = 0;
        sum += dfs(i+1, j, grid);
        sum += dfs(i, j+1, grid);
        sum += dfs(i-1, j, grid);
        sum += dfs(i, j-1, grid);
        return sum;
    }
}