class Solution {

    public int findMinDifference(List<String> timePoints) {

        int min1 = Integer.MAX_VALUE;

        ArrayList<Integer> arr = new ArrayList();

        for(int i=0; i<timePoints.size(); i++){

            int x = Integer.parseInt(timePoints.get(i).substring(0, 2));

            int y = Integer.parseInt(timePoints.get(i).substring(3, 5));

            int time = x * 60 + y;

            if(arr.contains(time)){
                return 0;
            }
            else{
                arr.add(time);
            }

        }

        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){

                int ans1 = Math.abs(arr.get(i) - arr.get(j));

                int ans2 = Math.abs(1440 - ans1);

                int ans = Math.min(ans1, ans2);

                if(ans<min1){
                    min1 = ans;
                }

            }
        }

        return min1;

    }
    
}
