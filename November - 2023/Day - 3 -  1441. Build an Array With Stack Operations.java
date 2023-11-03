class Solution {

    public List<String> buildArray(int[] target, int n) {

        List<String> arr = new ArrayList<>();
        
        int i = 0;

        int j = 0;

        while(i++<=n && j<target.length){

            arr.add("Push");

            if(i == target[j]){
                j++;
            }
            else{
                arr.add("Pop");
            }
            
        }

        return arr;

    }

}
