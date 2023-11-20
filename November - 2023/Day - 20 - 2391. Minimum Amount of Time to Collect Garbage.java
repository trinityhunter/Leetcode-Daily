class Pair{

    int ind;

    int count;

    public Pair(int ind, int count){
        this.ind = ind;
        this.count = count;
    }

}

class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        
        int n = garbage.length;

        HashMap<Character, Pair> map = new HashMap<>();

        int sum = 0;

        int[] pfSum = new int[n];

        for(int i=1; i<n; i++){
            sum += travel[i-1];
            pfSum[i] = sum;
        }


        for(int i=0; i<garbage.length; i++){
            String g = garbage[i];
            for(int j=0; j<g.length(); j++){
                char ch = g.charAt(j);
                if(!map.containsKey(ch)){
                    map.put(ch, new Pair(i, 1));
                }
                else{
                    Pair rp = map.get(ch);
                    rp.ind = i;
                    rp.count += 1;
                    map.put(ch, rp);
                }
            }
        }

        int ans = 0;

        for(Character key: map.keySet()){
            Pair rp = map.get(key);
            ans += (rp.count + pfSum[rp.ind]);
        }

        return ans;

    }

}
