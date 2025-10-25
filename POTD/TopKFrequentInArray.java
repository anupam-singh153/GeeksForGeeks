class Solution {
    
    private static class Pair implements Comparable<Pair>{
        int val;
        int freq;
        
        public Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair that){
            
            return this.freq == that.freq ? that.val - this.val : that.freq - this.freq;
        }
    }
    
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr)
            map.put(val, map.getOrDefault(val, 0)+1);
            
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int key : map.keySet()){
            
            pq.offer(new Pair(key, map.get(key)));
        }
        
        while(k > 0){
            
            result.add(pq.poll().val);
            k--;
        }
        
        return result;
    }
}
