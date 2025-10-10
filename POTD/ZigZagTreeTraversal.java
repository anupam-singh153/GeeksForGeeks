/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        boolean turn = true;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int levelSize = queue.size();
            ArrayList<Integer> row = new ArrayList<>();
            
            for(int i = 1; i <= levelSize; ++i){
                
                Node node = queue.poll();
                row.add(node.data);
              
                if(node.left != null)
                    queue.offer(node.left);
                        
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            if(!turn)
                Collections.reverse(row);
            
            result.addAll(row);
            
            turn = !turn;
        }
        
        return result;
    }
}
