/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to return a list containing the postorder traversal of the tree.
    
    void solve(Node root, ArrayList<Integer> ans){
        
        if(root == null)
            return;
            
        solve(root.left,ans);
        solve(root.right,ans);
        
        ans.add(root.data);
    }
    
    ArrayList<Integer> postOrder(Node root) {
        // Your code goes here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        solve(root,ans);
        
        return ans;
    }
}
