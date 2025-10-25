class Solution {
    public int minOperations(int[] arr) {
        // code here
        
        double originalSum = 0;
        
        PriorityQueue<Double> maxHeap = 
            new PriorityQueue<>((a, b) -> Double.compare(b, a));
     
        for(int val : arr){
            originalSum += val;
            maxHeap.offer(val*1.0);
        }
                 
        double newSum = 0;
        int steps = 0;
        double halfOriginalSum = originalSum/2;
        
        while(newSum < halfOriginalSum){
            
            double val = maxHeap.poll();
            newSum += val/2;
            maxHeap.offer(val/2);
            steps++;
        }
        
        return steps;
    }
}
