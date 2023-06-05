class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        
        int y = (y2 - y1);
        int x = (x1 - x2);
        int prev = y * x1 + x * y1;

        for(int i=2; i<coordinates.length; i++){
            int prod = y * coordinates[i][0] + x * coordinates[i][1];
            if(prod != prev){
                return false;
            }
        }

        return true;

    }

}
