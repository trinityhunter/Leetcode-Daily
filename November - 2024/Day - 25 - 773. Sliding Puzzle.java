class Solution {

    public int slidingPuzzle(int[][] board) {

        ArrayDeque<String> q = new ArrayDeque<>();

        String tar = "123450";
        
        String initial = "";

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                initial += (char)(board[i][j] + '0');
            }
        }
        
        int [][] charidx = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {1, 3, 5}, {4, 2}};

        q.add(initial);

        HashSet<String> visited = new HashSet<>();

        visited.add(initial);

        int level = 0;

        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){

                String rem = q.remove();

                if(rem.equals(tar) == true){
                    return level;
                }

                int idx = -1;

                for(int i = 0; i < rem.length(); i++){
                    if(rem.charAt(i) == '0'){
                        idx = i;
                        break;
                    }
                }

                int [] swappedidx = charidx[idx];

                for(int i = 0; i < swappedidx.length; i++){
                    String tobeadded = swap(rem, idx, swappedidx[i]);
                    if(visited.contains(tobeadded) == false){
                       visited.add(tobeadded);
                        q.add(tobeadded);
                    }
                    
                }
            }

            level++;

        }

        return -1;

    }

    public String swap(String str, int i, int j){

        StringBuilder sb = new StringBuilder(str);

        sb.setCharAt(i, str.charAt(j));

        sb.setCharAt(j, str.charAt(i));

        return sb.toString();

    }
    
}
