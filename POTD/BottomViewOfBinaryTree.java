class Solution {
    
    static class Pair{
        private Node node;
        private int pos;
        
        public Pair(Node node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    
    static ArrayList<Integer> bottomView(Node root) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
            
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root,0));
        
        while(!queue.isEmpty()){
           
           Pair p = queue.poll();
           
           int pos = p.pos;
           Node node = p.node;
           
           map.put(pos,node.data);
           
           if(node.left != null)
                queue.add(new Pair(node.left, pos-1));
                
            if(node.right != null)
                queue.add(new Pair(node.right, pos+1));
        }
        
        for(int val : map.values())
            result.add(val);
            
        return result;
    }
}
