class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        
        int M = grid.length;
        int N = grid[0].length;
        
        int[][] result = new int[M][N];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < M; ++i){
            for(int j = 0; j < N; ++j){
                if(grid[i][j] == 1){
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }
        
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr >= 0 && nr < M && nc >= 0 && nc < N 
                   && result[nr][nc] == -1){
                    result[nr][nc] = result[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int[] row : result){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int val : row) temp.add(val);
            ans.add(temp);
        }
        
        return ans;
    }
}
