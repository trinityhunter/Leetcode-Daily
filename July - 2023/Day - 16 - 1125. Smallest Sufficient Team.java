class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<req_skills.length; i++){
            hm.put(req_skills[i], i);
        }

        List<Integer>[] dp = new List[1 << req_skills.length];

        dp[0] = new ArrayList<>();
        
        int[] arr = new int[people.size()];

        for(int i=0; i<people.size(); i++){

            List<String> list = people.get(i);

            int val = 0;

            for(String skill: list){
                val |= 1 << hm.get(skill);
            }

            arr[i] = val;

        }

        boolean[] vis = new boolean[people.size()];

        for(int i=0; i<people.size(); i++){

            for(int j=i+1; j<people.size(); j++){
                
                int val = arr[i] | arr[j];

                if(val == arr[i]){
                    vis[j] = true;
                } 
                else if(val == arr[j]){
                    vis[i] = true;
                }

            }

        }

        for(int i=0; i<people.size(); i++){
            if(vis[i]){
                continue;
            }

            int curr = arr[i];
            
            for(int j=0; j<dp.length; j++){
                if(dp[j] == null){
                    continue;
                }

                int temp = j | curr;

                if(dp[temp] == null || dp[j].size() + 1 < dp[temp].size()){
                    dp[temp] = new ArrayList<>(dp[j]);
                    dp[temp].add(i);
                }
            }

        }

        return dp[(1 << req_skills.length) - 1].stream().mapToInt(i -> i).toArray();

    }

}
