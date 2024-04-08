class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<students.length; i++){
            arr.add(students[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=sandwiches.length-1; i>=0; i--){
            st.push(sandwiches[i]);
        }
        
        for(int i=0; i<students.length; i++){
            for(int j=0; j<arr.size(); j++){
                if(arr.get(j) == st.peek()){
                    st.pop();
                    arr.remove(j);
                }
                else{
                    int temp = arr.get(j);
                    arr.remove(j);
                    arr.add(temp);
                }
            }
        }
        
        return arr.size();

    }

}
