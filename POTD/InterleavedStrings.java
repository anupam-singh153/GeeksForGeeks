class Solution {
    
    private Boolean[][] dp;
    
    private boolean solve(String s1, String s2, String s3, int i, int j){
        
        int k = i + j;
        
        if(k == s3.length() && i == s1.length() && j == s2.length())
            return true;
        
        if(dp[i][j] != null)
            return dp[i][j];
            
        boolean flag1 = false;
        
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k))
            flag1 = solve(s1,s2,s3,i+1,j);
            
        boolean flag2 = false;
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
            flag2 = solve(s1,s2,s3,i,j+1);
     
        return dp[i][j] = flag1 || flag2;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        
        int m = s1.length();
        int n = s2.length();
       
        dp = new Boolean[m+1][n+1];
        
        return solve(s1,s2,s3,0,0);
    }
}
