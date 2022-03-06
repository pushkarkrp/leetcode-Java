class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int result = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = node[0] + dir[j][0];
                    int y = node[1] + dir[j][1];
                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 2|| grid[x][y] == 0) {
                        continue;    
                    }
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                    fresh--;
                }
            }
        }
        return fresh == 0 ? result - 1: -1;
    }
}