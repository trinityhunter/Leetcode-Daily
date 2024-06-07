class Solution {

    public String replaceWords(List<String> dict, String sentence) {

        Set<String> s = new HashSet<>(dict);

        List<String> temp = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        
        StringBuilder res = new StringBuilder();
        
        for(String t: temp){

            int i = 0;

            while(i <= t.length()){

                String curr = t.substring(0, i);

                if(s.contains(curr)){
                    res.append(curr).append(" ");
                    break;
                }

                i++;

            }

            if(i == t.length() + 1){
                res.append(t).append(" ");
            }

        }
        
        res.deleteCharAt(res.length() - 1);

        return res.toString();

    }
    
}
