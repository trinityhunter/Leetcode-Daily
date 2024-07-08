class Solution {
    
    public static void getHelp(List<Integer> arr, int k, int ind){
        
        if(arr.size() == 1){
            return;
        }
        
        ind = (ind + k - 1) % arr.size();
        
        arr.remove(ind);
        
        getHelp(arr, k, ind);
        
    }
    
    public int findTheWinner(int n, int k) {
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            arr.add(i);
        }
        
        getHelp(arr, k, 0);
        
        return arr.get(0);
        
    }
    
}
