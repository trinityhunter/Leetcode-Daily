class Solution {

    public List<String> removeSubfolders(String[] folder) {

        ArrayList<String> arr = new ArrayList<>();

        Arrays.sort(folder);

        arr.add(folder[0]);
        
        for(int i=1; i<folder.length; i++){

            String last =arr.get(arr.size()-1) +  "/" ;

            if(folder[i].startsWith(last) == false){
                arr.add(folder[i]);

            }

        }

        return arr;

    }
    
}
