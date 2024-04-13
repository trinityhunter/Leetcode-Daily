class Pair{

    int val;
    int ind;

    Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }

}

class Solution {

    public static int[] nextSmallerToLeft(int[] heights){

        Stack<Pair> st = new Stack<>();

        int[] arr = new int[heights.length];

        for(int i=0; i<heights.length; i++){

            if(st.size() == 0){
                arr[i] = -1;
            }
            else if(st.size()>0 && st.peek().val < heights[i]){
                arr[i] = st.peek().ind;
            }
            else if(st.size()>0 && st.peek().val >= heights[i]){

                while(st.size()>0 && st.peek().val >= heights[i]){
                    st.pop();
                }

                if(st.size() == 0){
                    arr[i] = -1;
                }
                else{
                    arr[i] = st.peek().ind;
                }

            }

            st.push(new Pair(heights[i], i));

        }

        return arr;

    }

    public static int[] nextSmallerToRight(int[] heights){

        Stack<Pair> st = new Stack<>();

        int[] arr = new int[heights.length];

        for(int i=heights.length-1; i>=0; i--){

            if(st.size() == 0){
                arr[i] = heights.length;
            }
            else if(st.size()>0 && st.peek().val < heights[i]){
                arr[i] = st.peek().ind;
            }
            else if(st.size()>0 && st.peek().val >= heights[i]){

                while(st.size()>0 && st.peek().val >= heights[i]){
                    st.pop();
                }

                if(st.size() == 0){
                    arr[i] = heights.length;
                }
                else{
                    arr[i] = st.peek().ind;
                }

            }

            st.push(new Pair(heights[i], i));

        }

        return arr;

    }

    public int largestRectangleArea(int[] heights) {
        
        int[] nsr = nextSmallerToRight(heights);

        int[] nsl = nextSmallerToLeft(heights);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++){
            max = Math.max(max, heights[i] * (nsr[i] - nsl[i] - 1));
        }

        return max;

    }

    public int maximalRectangle(char[][] matrix) {
        
        int max = 0;

        int[] height = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }

            int area = largestRectangleArea(height);

            max = Math.max(max, area);

        }

        return max;

    }

}
