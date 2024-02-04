class Solution {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0;
        
        int j = 0;

        int min = Integer.MAX_VALUE;

        int start = 0;

        int mini = Integer.MAX_VALUE;

        String ans = "";
        
        for(int ind=0; ind<t.length(); ind++){
            hm.put(t.charAt(ind), hm.getOrDefault(t.charAt(ind), 0) + 1);
        }
        
        int count = hm.size();

        while(j<s.length()){

            if(hm.containsKey(s.charAt(j))){

                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) - 1);
                
                if(hm.get(s.charAt(j)) == 0){
                    count--;
                }

            }

            if(count>0){
                j++;
            }
            else if(count == 0){
                if(mini > j-i+1){
                    mini = Math.min(mini, j-i+1);
                    ans = s.substring(i, j+1);
                }
                while(count == 0){

                    if(!hm.containsKey(s.charAt(i))){

                        i++;

                        mini = Math.min(mini,j-i+1);

                        min = Math.min(min,i);

                    }
                    else{

                        hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);

                        if(hm.get(s.charAt(i))>0){

                            i++;

                            count++;

                            if(mini>j-i+1){
                                mini = Math.min(mini, j-i+1);
                                ans = s.substring(i-1, j+1);
                            }

                        }
                        else{
                            i++;  
                        }

                    }

                }

                j++;

            }
            
        }

        return ans;

    }

}
