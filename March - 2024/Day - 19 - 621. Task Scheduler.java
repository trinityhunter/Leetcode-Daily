class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(int i=0; i<tasks.length; i++){
            freq[tasks[i]-'A']++; 
        }
        
        int max = 0;

        int count = 0;

        for(int i=0; i<26; i++){
            max = Math.max(max, freq[i]);
        }

        for(int i=0; i<26; i++){
            if(freq[i] == max){
                count++;
            }
        }

        return Math.max(((n+1)*(max-1)) + count, tasks.length);

    }

}
