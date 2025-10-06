class Solution {
    
    private static boolean result;
    private static int[][] directions;
    
    static{
        
        directions = new int[][]{{-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}};
    }
    
    private void solve(int[][] board, int r, int c, int num){
        
        int N = board.length;
        
        if(num == N*N){
            result = true;
            return;
        }
        
        if(r < 0 || r >= N || c < 0 || c >= N || board[r][c] != -1)
            return;
            
        board[r][c] = num;
        
        boolean flag = false;
        
        for(int[] dir : directions){
            
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            solve(board, nr, nc, num+1);
            
            if(result) break;
        }
        
        if(!result)
            board[r][c] = -1;
        return;
    }
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        // code here
        
        int[][] board = new int[n][n];
        result = false;
        
        for(int[] row : board)
            Arrays.fill(row, -1);
            
        solve(board, 0, 0, 0);
        
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        
        if(!result) return grid;
        
        for(int[] nums : board){
            ArrayList<Integer> row = new ArrayList<>();
            for(int num : nums){
                row.add(num);
            }
            grid.add(row);
        }
        
        return grid;
    }
}
