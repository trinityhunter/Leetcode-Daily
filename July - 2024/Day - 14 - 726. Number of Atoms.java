class Solution {

    public String countOfAtoms(String formula) {
        
        int runningMultiplier = 1;

        int[] multiplier = new int[formula.length()];

        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder answer = new StringBuilder();

        StringBuilder currentNumber = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for(int index = formula.length()-1; index>=0; index--){
            if(Character.isDigit(formula.charAt(index))){
                currentNumber.insert(0, formula.charAt(index));
            }
            else if(Character.isAlphabetic(formula.charAt(index))){
                currentNumber = new StringBuilder();
            }
            else if(formula.charAt(index) == '('){
                runningMultiplier /= stack.pop();
                currentNumber = new StringBuilder();
            }
            else if(formula.charAt(index) == ')'){
                int currentMultiplier = currentNumber.length() > 0 ? Integer.parseInt(currentNumber.toString()) : 1;

                stack.push(currentMultiplier);
                runningMultiplier *= currentMultiplier;
                currentNumber = new StringBuilder();
            }

            multiplier[index] = runningMultiplier;

        }

        for(int index = 0; index < formula.length(); index++){
            if(!Character.isUpperCase(formula.charAt(index))){
                continue;
            }

            StringBuilder cuurentCount = new StringBuilder();

            StringBuilder currentAtom = new StringBuilder();

            currentAtom.append(formula.charAt(index++));

            while(index < formula.length() && Character.isLowerCase(formula.charAt(index))){
                currentAtom.append(formula.charAt(index++));
            }

            while(index < formula.length() && Character.isDigit(formula.charAt(index))){
                cuurentCount.append(formula.charAt(index++));
            }

            String atom = currentAtom.toString();

            int count = multiplier[--index] * (cuurentCount.length() > 0 ? Integer.parseInt(cuurentCount.toString()) : 1);

            map.put(atom, map.getOrDefault(atom, 0) + count);

        }

        for(String atom : map.keySet()){
            answer.append(atom);
            
            if (map.get(atom) > 1) {
                answer.append(map.get(atom));
            }
        }

        return answer.toString();

    }
    
}
