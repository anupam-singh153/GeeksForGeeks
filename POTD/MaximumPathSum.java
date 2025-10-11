/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    
    private int ans = Integer.MIN_VALUE;
    
    int findMaxSum(Node root){
        
        findSum(root);
        return ans;
    }
    
    int findSum(Node root) {
        // code here
        
        if(root == null)
            return 0;
            
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        
        int result = root.data;
        
        if(leftSum > 0)
            result += leftSum;
            
        if(rightSum > 0)
            result += rightSum;
            
        ans =  Math.max(ans, result);
        return Math.max(root.data, root.data+Math.max(leftSum, rightSum));
    }
}
