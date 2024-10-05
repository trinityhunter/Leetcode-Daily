class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }
        
        HashMap<Character, Integer> hm1 = new HashMap<>();

        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(hm1.equals(hm2)){
            return true;
        }

        for(int i=s1.length(); i<s2.length(); i++){

            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);

            if(hm2.get(s2.charAt(i-s1.length())) == 1){
                hm2.remove(s2.charAt(i-s1.length()));
            }
            else{
                hm2.put(s2.charAt(i-s1.length()), hm2.getOrDefault(s2.charAt(i-s1.length()), 0) - 1);
            }

            if(hm1.equals(hm2)){
                return true;
            }

        }

        return false;

    }

}
