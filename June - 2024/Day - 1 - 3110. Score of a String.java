class Solution {

    public int scoreOfString(String s) {

        int[] arr = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            arr[i] = (int)s.charAt(i);
        }

        int count = 0;

        for(int i=1; i<arr.length; i++){
            count += Math.abs(arr[i] - arr[i-1]);
        }

        return count;

    }

}
