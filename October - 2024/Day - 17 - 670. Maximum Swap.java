class Solution {

    public int maximumSwap(int num) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] != a[1] ? b[1]-a[1] : b[0]-a[0]);

        char[] numStr = String.valueOf(num).toCharArray();

        for(int i=0; i<numStr.length; i++){
            pq.add(new int[]{i, numStr[i] - '0'});
        }

        for(int i=0; i<numStr.length; i++){

            int cur = numStr[i] - '0';

            while(cur < pq.peek()[1] && i > pq.peek()[0]){
                pq.poll();
            }

            if(!pq.isEmpty() && cur < pq.peek()[1]){

                int[] p = pq.poll();

                char temp = numStr[i];

                numStr[i] = (char)('0' + p[1]);

                numStr[p[0]] = temp;

                break;

            } 

        }

        return Integer.parseInt(new String(numStr));

    }
    
}
