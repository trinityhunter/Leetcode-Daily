class Solution {

    static int i = 0;

    static public boolean parseBoolExpr(String expression){

        i = 0;

        return solveIt(expression);

    }
    
    static boolean solveIt(String str){

        char ch = str.charAt(i);

        if(ch == 't'){
            return true;
        }

        if(ch == 'f'){
            return false;
        }

        if(ch == '|'){

            i = i + 2;

            boolean expression = solveIt(str);

            i++;

            while(i < str.length() && str.charAt(i) != ')'){
                ++i;
                expression = solveIt(str) || expression;
                i++;
            }

            return expression;

        } 
        else if(ch == '&'){

            i = i + 2;

            boolean expression = true && solveIt(str);

            i++;

            while(i < str.length() && str.charAt(i) != ')'){
                ++i;
                expression = solveIt(str) && expression;
                i++;
            }

            return expression;

        }

        i = i + 2;

        boolean expression = !(solveIt(str));

        i++;

        return expression;

    }

}
