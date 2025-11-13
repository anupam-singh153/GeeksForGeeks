class Solution {
    
    private int getNextIdx(int[][] jobs, int low, int target){
        
        int N = jobs.length;
        int high = N-1, result = N;
        
        while(low <= high){
            
            int m = low + (high - low)/2;
            
            if(jobs[m][0] >= target){
                result = m;
                high = m-1;
            }
            else{
                low = m+1;
            }
        }
        
        return result;
    }
    
    private int solve(int[][] jobs, int i, int[] dp){
        
        if(i >= jobs.length)
            return 0;
            
        if(dp[i] != -1)
            return dp[i];
            
        int j = getNextIdx(jobs, i, jobs[i][1]);
        
        int include = jobs[i][2] + solve(jobs, j, dp);
        
        int exclude = solve(jobs, i+1, dp);
        
        return dp[i] = Math.max(include, exclude);
    }
    
    public int maxProfit(int[][] jobs) {
        // code here
        
        Arrays.sort(jobs, (j1, j2)-> Integer.compare(j1[0], j2[0]));
        
        int[] dp = new int[jobs.length];
        Arrays.fill(dp, -1);
        
        return solve(jobs, 0, dp);
    }
}
