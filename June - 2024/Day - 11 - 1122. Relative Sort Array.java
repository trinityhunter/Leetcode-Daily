class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        ArrayList<Integer> arra1 = new ArrayList<>();
        
        for(int i=0; i<arr1.length; i++){
            arra1.add(arr1[i]);
        } 
        
        
        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arra1.size(); j++){
                if(arr2[i]==arra1.get(j)){
                    arr.add(arra1.get(j));
                    arra1.remove(j);
                    j = -1;
                }    
            }
        }
        
        Collections.sort(arra1);
        
        for(int i=0; i<arra1.size(); i++){
            arr.add(arra1.get(i));
        }
        
        int [] array = new int [arr.size()];
        
        for(int i=0; i<array.length; i++){
            array[i] = arr.get(i);
        }
        
        return array;

    }
    
}
