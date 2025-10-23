class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        Arrays.sort(points, (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        
        for(int i = 0; i < k; ++i){
            
            ArrayList<Integer> row = new ArrayList<>();
            row.add(points[i][0]);
            row.add(points[i][1]);
            
            result.add(row);
        }
        
        return result;
    }
}
