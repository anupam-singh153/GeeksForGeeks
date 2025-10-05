class Solution {
    
    private static String[] arr;
    
    static{
        arr = new String[10];
        
        arr[2] = "abc"; arr[3] = "def";
        arr[4] = "ghi"; arr[5] = "jkl";
        arr[6] = "mno"; arr[7] = "pqrs";
        arr[8] = "tuv"; arr[9] = "wxyz";
    }
    
    private void dfs(int[] nums, int i, StringBuilder sb, ArrayList<String> result){
        
        if(i == nums.length){
            result.add(new String(sb));
            return;
        }
        
        if(nums[i] <= 1){
            dfs(nums, i+1, sb, result);
            return;
        }
                 
        for(char c : arr[nums[i]].toCharArray()){
            
            sb.append(c);
            dfs(nums, i+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        
        return;
    }
    public ArrayList<String> possibleWords(int[] nums) {
        // code here
        
        ArrayList<String> result = new ArrayList<>();
        dfs(nums, 0, new StringBuilder(), result);
        
        return result;
    }
}
