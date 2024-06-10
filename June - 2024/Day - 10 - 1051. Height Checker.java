class Solution {

    public int heightChecker(int[] heights) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<heights.length; i++){
            arr.add(heights[i]);
        }
        
        Collections.sort(arr);
        
        int count = 0;
        
        for(int i=0; i<heights.length; i++){
            if(heights[i] != arr.get(i)){
                count++;
            }
        }
        
        return count;
    
    }

}
