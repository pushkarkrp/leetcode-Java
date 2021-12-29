class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i<rooms.length; i++) {
            for (int j = 0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }  
    }
    
    private void dfs(int[][] rooms, int i, int j, int value) {
        if(rooms[i][j] == -1 || i < 0 || i>= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        if(rooms[i][j] != 0) {
            rooms[i][j] = value;   
        }
        if(i + 1 < rooms.length && rooms[i + 1][j] > value + 1) {
           dfs(rooms, i + 1, j, value + 1); 
        }
        if(i - 1 >= 0 && rooms[i - 1][j] > value + 1) {
           dfs(rooms, i - 1, j, value + 1); 
        }
        if(j + 1 < rooms[0].length && rooms[i][j + 1] > value + 1) {
           dfs(rooms, i, j + 1, value + 1); 
        }
        if(j - 1 >= 0 && rooms[i][j - 1] > value + 1) {
           dfs(rooms, i, j - 1, value + 1); 
        }
    }
}