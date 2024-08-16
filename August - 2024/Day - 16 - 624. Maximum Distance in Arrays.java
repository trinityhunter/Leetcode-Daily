class Solution {

    class Pair{

        int val;

        int ind;

        Pair(int v,int i){
            this.val = v;
            this.ind = i;
        }

    }

    public int maxDistance(List<List<Integer>> arrays) {

        // int mini = Integer.MAX_VALUE;
        // int maxi = Integer.MIN_VALUE;

        PriorityQueue<Pair> smallest = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        PriorityQueue<Pair> largest = new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));

        // for(List<Integer> i:arrays){
        //     mini = Math.min(i.get(0),mini);
        //     maxi = Math.max(maxi,i.get(i.size()-1));
        // }

        for(int i=0; i<arrays.size(); i++){
            smallest.offer(new Pair(arrays.get(i).get(0), i));
            largest.offer(new Pair(arrays.get(i).get(arrays.get(i).size()-1), i));
        }

        if(smallest.peek().ind!=largest.peek().ind) return Math.abs(smallest.peek().val-largest.peek().val);

        int mini = smallest.peek().val;
        
        int i = smallest.poll().ind;
        
        int maxi = largest.peek().val;
        
        int j = largest.poll().ind;

        int answer = Integer.MIN_VALUE;

        // List<Pair> temp = new ArrayList<>();

        while(i == largest.peek().ind){
            largest.poll();
        }

        answer = Math.max(answer,Math.abs(largest.peek().val-mini));

        while(j == smallest.peek().ind){
            smallest.poll();
        }

        answer = Math.max(answer,Math.abs(smallest.peek().val - maxi));
        
        return answer;
        
    }
    
}
