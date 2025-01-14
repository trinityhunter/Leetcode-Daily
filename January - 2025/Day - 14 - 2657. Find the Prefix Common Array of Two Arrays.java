class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        HashSet<Integer> setA = new HashSet<>();

        HashSet<Integer> setB = new HashSet<>();

        int[] arr = new int[A.length];

        for(int i=0; i<A.length; i++){
            setA.add(A[i]);
            setB.add(B[i]);

            int count = 0;

            if(A[i] == B[i]){
                if(setB.contains(A[i])){
                    count++;
                }
            }
            else{
                if(setB.contains(A[i])){
                    count++;
                }
                if(setA.contains(B[i])){
                    count++;
                }
            }

            if(i == 0){
                arr[i] = count;
            }
            else{
                arr[i] = arr[i-1] + count;
            }

        }

        return arr;

    }

}
