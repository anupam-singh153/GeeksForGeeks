class Solution {
    
    private int solve(int n, int[] dp){
        
        if(n == 0)
            return 1;
           
        if(dp[n] != -1)
            return dp[n];
            
        int two_X_one = 0 , one_X_two = 0;
        
        //put single tile of 2X1
        if(n >= 1)
            two_X_one = solve(n-1, dp);
        
        //put two tiles of 1X2
        if(n >= 2)
            one_X_two = solve(n-2, dp);
        
        return dp[n] = two_X_one + one_X_two;
    }
    
    public int numberOfWays(int n) {
        // code here
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return solve(n, dp);
    }
};
