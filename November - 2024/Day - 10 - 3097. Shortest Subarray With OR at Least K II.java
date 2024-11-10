class Solution {
    
	public static int getVal(Map<Integer, Integer> map){

		int ans = 0;

		for(int i : map.keySet()){

			if(map.get(i)>0) {
				ans += Math.pow(2, i);
			}

		}

		return ans;

	}
	
	public static Map<Integer, Integer> removeBits(int n, Map<Integer, Integer> map){

		int ind = 0;

		while(n>0){

			int rem = n%2;

			if(rem == 1){
                
				if(map.containsKey(ind)) {
					map.put(ind, map.get(ind)-1);
				}

			}

			n /= 2;

			ind += 1;

		}

		return map;

	}
	
	public static void addBits(int n, Map<Integer, Integer> map){

		int ind = 0;

		while(n>0){

			int rem = n%2;

			if(rem == 1){

				if(map.containsKey(ind)){

					map.put(ind, map.get(ind)+1);

				}
                else{

					map.put(ind, 1);

				}

			}

			n /= 2;

			ind += 1;

		}

	}

	public static int minimumSubarrayLength(int[] nums, int k){
        
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
		int initLen = 0;

		for(int i=0; i<nums.length; i++){

			int x = nums[i];

			if(x>=k){

				return 1;

			}

			addBits(x, map);

			if(getVal(map) >= k){
				initLen = i;
				break;
			}

		}
		
		if(initLen == 0){
			return -1;
		}
        else{
            
			int right = initLen;
			
			removeBits(nums[0], map);
			
			for(int i=1; i<=nums.length-1; i++){
				
				while(getVal(map)<k){

					right += 1;

					try{
						addBits(nums[right], map);
					}
                    catch(Exception e) {
						break;
					}

				}
				
				if(initLen>(right-i)){
					initLen = right - i;
				}
				
				removeBits(nums[i], map);
                
			}

			return initLen+1;

		}

    }

}
