/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    
    private int solve(Node root, int canInclude, Map<Node, int[]> dp){
        
        if(root == null)
            return 0;
        
        if(!dp.containsKey(root))
            dp.put(root, new int[]{-1, -1});
            
        if(dp.get(root)[canInclude] != -1)
            return dp.get(root)[canInclude];
            
        int include = 0;
        
        //include
        if(canInclude == 1)
            include = root.data + solve(root.left, 0, dp) + solve(root.right, 0, dp);
        
       //exclude
        int exclude = solve(root.left, 1, dp) + solve(root.right, 1, dp);
        
        return dp.get(root)[canInclude] = Math.max(include, exclude);
    }
    
    public int getMaxSum(Node root) {
        // code here
        
        Map<Node, int[]> dp = new HashMap<>();
        
        return solve(root, 1, dp);
    }
}
