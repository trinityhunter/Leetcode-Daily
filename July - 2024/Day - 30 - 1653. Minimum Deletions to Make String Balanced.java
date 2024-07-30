class Solution {

    public int minimumDeletions(String s) {

        char[] arr = s.toCharArray();

        int[] aafter = new int[arr.length];

        int[] bbefore = new int[arr.length];

        if(arr.length == 1){
            return 0;
        }

        if(arr[0] == 'a'){
            aafter[0] = 1;
        }

        if(arr[0] == 'b'){
            bbefore[0] = 1;
        }

        for(int i=1; i<arr.length; i++){

            aafter[i] = aafter[i - 1];
            bbefore[i] = bbefore[i - 1];

            if(arr[i] == 'a'){
                aafter[i]++;
            }

            if(arr[i] == 'b'){
                bbefore[i]++;
            }

        }

        int totalA = aafter[aafter.length - 1];

        int totalB = bbefore[bbefore.length - 1];

        int min = Math.min(totalA, totalB);

        for(int i=0; i<arr.length; i++){
            min = Math.min(min, bbefore[i] + (totalA - aafter[i]));
        }
        
        return min;

    }

}   
