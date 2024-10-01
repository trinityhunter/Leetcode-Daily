class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
            int key = arr[i]%k;
            
            if(key<0){
                key += k;
            }
            
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        
        for(int key: hm.keySet()){
		    
		    if(key == 0){
		        if(hm.get(key) % 2!=0){
      		        return false;
		        }
		    }
		    else if(key*2 == k){
		        if(hm.get(key) % 2!=0){
      		        return false;
		        }
		    }
		    else{
                
                int count1 = hm.get(key);
                
                int count2 = hm.getOrDefault(k-key, 0);
                
    		    if(count1 != count2){
    		        return false;
    		    }    
		    }
		}
        
        return true;
        
    }
}
