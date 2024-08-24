public class Solution {

    public static String nearestPalindromic(String n) {

        if(n.equals("1")){
            return "0";
        }
        
        int length = n.length();

        long num = Long.parseLong(n);

        Set<Long> candidates = new HashSet<>();
        
        candidates.add((long) Math.pow(10, length) + 1);
        candidates.add((long) Math.pow(10, length - 1) - 1);
        
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));

        for(long i=-1; i<=1; i++){

            String candidate = String.valueOf(prefix + i);

            if(length % 2 == 0){
                candidate = candidate + new StringBuilder(candidate).reverse().toString();
            } 
            else{
                candidate = candidate + new StringBuilder(candidate).reverse().substring(1);
            }

            candidates.add(Long.parseLong(candidate));

        }
        
        candidates.remove(num);
        
        long closest = -1;

        for(long candidate : candidates){

            if(closest == -1 || Math.abs(candidate - num) < Math.abs(closest - num) ||
                (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)){
                closest = candidate;
            }

        }
        
        return String.valueOf(closest);

    }

    public static void main(String[] args) {
        
        String n = "123";

        System.out.println(nearestPalindromic(n));

    }
    
}
