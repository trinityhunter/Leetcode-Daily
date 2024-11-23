class Solution {

    public char[][] rotateTheBox(char[][] box){

        char[][] arr = new char[box[0].length][box.length];

        for(int i=0; i<box.length; i++){

            for(int j=box[0].length-1, k=box[0].length-1; j>=0; j--){

                arr[j][box.length-i-1] = '.';

                if(box[i][j]!='.'){
                    k = box[i][j] == '*' ? j: k;
                    arr[k--][box.length-i-1] = box[i][j];
                }

            }

        }

        return arr;

    }

}
