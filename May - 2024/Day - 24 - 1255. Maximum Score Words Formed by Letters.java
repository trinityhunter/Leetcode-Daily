class Solution {
    
    public static int helper(String[] words, int n, int i, int[] freq, int[] score, ArrayList<HashMap<String, Integer>> dp){
        
        if(i == n){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();

        for(int j=0; j<26; j++){
            if(freq[j] != 0){
                sb.append(Integer.toString(freq[j]) + (char)(j + 97));
            }
        }
        
        String t = sb.toString();
        
        if(dp.get(i).containsKey(t)){
            return dp.get(i).get(t);
        }
        
        int notPick = helper(words, n, i + 1, freq, score, dp);
        
        int pick = 0;
        
        int[] temp = new int[26];

        int flag = 0;

        for(int j=0; j<words[i].length(); j++){
            int curr = (int)words[i].charAt(j) - 97;
            temp[curr]++;
            if(temp[curr] > freq[curr]){
                flag = 1;
                break;
            }
        }
        
        if(flag == 0){
        
            int currScore = 0;
            
            for(int j=0; j<26; j++){
                freq[j] -= temp[j];
                currScore += temp[j] * score[j];
            }
            
            pick = currScore + helper(words, n, i + 1, freq, score, dp);
            
            for(int j=0; j<26; j++){
                freq[j] += temp[j];
            }
        }
        
        int ans = Math.max(notPick, pick);
        dp.get(i).put(t, ans);
        return ans;
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        if(words.length == 0){
            return 0;
        }
        
        if(letters.length == 0){
            return 0;
        }
        
        int[] freq = new int[26];

        for(int i=0; i<letters.length; i++){
            freq[(int)letters[i] - 97]++;
        }
        
        ArrayList<HashMap<String, Integer>> dp = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            dp.add(new HashMap<>());
        }
        
        return helper(words, words.length, 0, freq, score, dp);
        
    }

}
