/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    private static class Pair implements Comparable<Pair>{
        int val;
        int dist;
        
        public Pair(int val, int dist){
            this.val = val;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Pair that){
            
            return this.dist == that.dist ? this.val - that.val : this.dist - that.dist;
        }
    }
    
    private void inorder(Node root, int target, PriorityQueue<Pair> heap){
        
        if(root == null)
            return;
            
        inorder(root.left, target, heap);
        
        heap.offer(new Pair(root.data, Math.abs(root.data - target)));
        
        inorder(root.right, target, heap);
    }
    
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        inorder(root, target, heap);
        
        while(k-- > 0){
            
            result.add(heap.poll().val);
        }
        
        return result;
    }
}
