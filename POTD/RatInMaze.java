class Solution {
    
    private static int N;
    private static int[][] directions;
    private static String dirString;
    
    static{
        directions = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; //DLRU
        dirString = "DLRU";
    }
    
    private void dfs(int[][] maze, int r, int c, StringBuilder sb, 
                            ArrayList<String> result){
            
        if(r == N-1 && c == N-1){
            result.add(new String(sb));
            return;
        }
        
        if(r < 0 || r >= N || c < 0 || c >= N || maze[r][c] != 1)
            return;
           
        maze[r][c] = -1;
         
        for(int i = 0; i < 4; ++i){
            
            int nr = directions[i][0] + r;
            int nc = directions[i][1] + c;
            
            sb.append(dirString.charAt(i));
            dfs(maze, nr, nc, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        
        maze[r][c] = 1;
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        
        N = maze.length;
        
        ArrayList<String> result = new ArrayList<>();
        
        dfs(maze, 0, 0, new StringBuilder(), result);
        
        return result;
    }
}
