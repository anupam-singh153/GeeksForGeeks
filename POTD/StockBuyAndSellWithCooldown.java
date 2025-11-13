class Solution {
    
    private int solve(int[] arr, int i, int canBuy, int[][] dp){
        
        if(i >= arr.length)
            return 0;
            
        if(dp[i][canBuy] != -1)
            return dp[i][canBuy];
            
        //include
        
        int include = 0;
        
        if(canBuy == 1){
            include = -arr[i] + solve(arr, i+1, 0, dp);
        }
        else{
            include = arr[i] + solve(arr, i+2, 1, dp);  //next precure on 1 day later
        }
        
        int exclude = solve(arr, i+1, canBuy, dp);
        
        return dp[i][canBuy] = Math.max(include, exclude);
    }
    
    public int maxProfit(int arr[]) {
        // Code here
        
        int N = arr.length;
        
        int[][] dp = new int[N][2];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
            
        return solve(arr, 0, 1, dp);
    }
}
