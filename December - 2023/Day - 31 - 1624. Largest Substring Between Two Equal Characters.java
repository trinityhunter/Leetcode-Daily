class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {

        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<s.length(); i++){
            
            Character ch = s.charAt(i);

            if(arr[ch-'a']!=-1){
                max = Math.max(max, i-arr[ch-'a']-1);
            }
            else{
                arr[ch-'a'] = i;
            }
        }

        if(max == Integer.MIN_VALUE){
            return -1;
        }

        return max;

    }

}
