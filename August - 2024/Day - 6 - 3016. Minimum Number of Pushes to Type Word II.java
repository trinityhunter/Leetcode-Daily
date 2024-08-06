class Solution {

    public int minimumPushes(String word) {

        int[] count = new int[26];

        for(char c: word.toCharArray()){
            count[c - 'a']++;
        }

        Arrays.sort(count);

        int pushes = 0;

        int multiplier = 1;

        for(int i=25; i>=0; i--){

            if(count[i] == 0){
                break;
            }

            pushes += count[i] * multiplier;

            if((25 - i + 1)%8 == 0){
                multiplier++;
            }

        }

        return pushes;

    }
    
}
