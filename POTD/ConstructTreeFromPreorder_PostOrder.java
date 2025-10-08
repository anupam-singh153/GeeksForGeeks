/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    private Node buildTree(int[] pre, int preSt, int preEnd, 
                                int[] post, int postSt, int postEnd){
            
        if(preSt > preEnd || postSt > postEnd)
            return null;
            
        Node root = new Node(pre[preSt]);
        
        if(preSt == preEnd)
            return root;
            
        int leftRootVal = pre[preSt+1];
        int idx = postSt;
        
        while(idx <= postEnd && post[idx] != leftRootVal)
            idx++;
         
        int len = idx - postSt + 1;   
         
        root.left = buildTree(pre, preSt+1,preSt+len, 
                        post, postSt, idx);
                        
        root.right = buildTree(pre, preSt+len+1, preEnd,
                        post, idx+1, postEnd-1);
                        
        return root;
    }
    
    public Node constructTree(int[] pre, int[] post) {
        // code here
        
        int N = post.length;
        return buildTree(pre, 0, N-1, post, 0, N-1);
    }
}
