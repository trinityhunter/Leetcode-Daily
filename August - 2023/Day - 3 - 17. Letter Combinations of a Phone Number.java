class Solution {
    
    public static List<String> getC(String digits, List<String> code){
        
        if(digits.length() == 0){
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        
        String fl = digits.charAt(0) + "";
        
        String rem = digits.substring(1);
        
        List<String> prev = getC(rem, code);
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<code.get(Integer.valueOf(fl+"")).length(); i++){
            for(int j=0; j<prev.size(); j++){
                ans.add(code.get(Integer.parseInt(fl)).charAt(i) + prev.get(j) + "");
            }
        }
        
        return ans;
        
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> code = new ArrayList<>();
        code.add("");
        code.add("");
        code.add("abc");
        code.add("def");
        code.add("ghi");
        code.add("jkl");
        code.add("mno");
        code.add("pqrs");
        code.add("tuv");
        code.add("wxyz");
        
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        
        return getC(digits, code);
        
    }
    
}
