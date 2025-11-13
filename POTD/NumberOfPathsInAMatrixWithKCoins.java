class Solution {
    
    private static int M, N;
    
    private int solve(int[][] mat, int r, int c, int k, int[][][] dp){
        
        if(r == M-1 && c == N-1)
            return k == mat[r][c] ? 1 : 0;
            
        if(r >= M || c >= N || k < 0)
            return 0;
            
        if(dp[r][c][k] != -1)
            return dp[r][c][k];
            
        int goRight = solve(mat, r, c+1, k-mat[r][c], dp);
        int goDown = solve(mat, r+1, c, k-mat[r][c], dp);
        
        return dp[r][c][k] = goRight + goDown;
    }
    
    public int numberOfPath(int[][] mat, int k) {
        // code here
        
        M = mat.length;
        N = mat[0].length;
        
        int[][][] dp = new int[M][N][k+1];
        
        for(int[][] row : dp)
            for(int[] col : row)
                Arrays.fill(col, -1);
                
        return solve(mat, 0, 0, k, dp);
    }
}
