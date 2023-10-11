class Solution {
    
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        List<Integer> temp = new ArrayList<>();
        
        for(int[] f: flowers){
            temp.add(f[0]);
            temp.add(f[1]);
            temp.add(f[1] + 1);
        }

        for(int ele: people){
            temp.add(ele);
        }
        
        Collections.sort(temp);

        HashMap<Integer , Integer> map = new HashMap<>();

        int ptr = 0;

        HashMap<Integer , Integer> map2 = new HashMap<>();

        for(int ele: temp){
            if(!map.containsKey(ele)){
                map.put(ele , ptr);
                map2.put(ptr , ele);
                ptr++;
            }
        }

        long[] t = new long[ptr+1];

        for(int[] f: flowers){
            int start = map.get(f[0]);
            int end = map.get(f[1] + 1);
            t[start]++;
            t[end]--;
        }

        long sum = 0;

        for(int i=0 ; i<=ptr; i++){
            sum += t[i];
            t[i] = sum;
        }
        
        int[] ans = new int[people.length];

        for(int i=0; i<people.length; i++){
            int ele = map.get(people[i]);
            ans[i] = (int) t[ele]; 
        }

        return ans;

    }
    
}
