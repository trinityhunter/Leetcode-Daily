class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        
        List<Integer> robotIndices = new ArrayList<>();

        for(int i=0; i<n; i++){
            robotIndices.add(i);
        }

        robotIndices.sort((a, b) -> Integer.compare(positions[a], positions[b]));
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int index : robotIndices){
            if(directions.charAt(index) == 'R'){
                stack.push(index);
            } 
            else{
                while(!stack.isEmpty() && healths[index] > 0){

                    int rightRobotIndex = stack.peek();

                    if(healths[rightRobotIndex] < healths[index]){
                        healths[rightRobotIndex] = 0;
                        healths[index]--;
                        stack.pop();
                    } 
                    else if(healths[rightRobotIndex] > healths[index]){
                        healths[rightRobotIndex]--;
                        healths[index] = 0;
                    } 
                    else{
                        healths[rightRobotIndex] = 0;
                        healths[index] = 0;
                        stack.pop();
                    }
                }
            }
        }
        
        List<Integer> survivingHealths = new ArrayList<>();

        for(int health : healths){
            if(health > 0){
                survivingHealths.add(health);
            }
        }
        
        return survivingHealths;

    }
    
}
