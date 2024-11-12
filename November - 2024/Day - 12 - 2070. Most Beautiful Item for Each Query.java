class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Arrays.sort(items,(a,b) -> Integer.compare(a[0],b[0]));

        for(int i=1; i<items.length; i++){
            items[i][1] = Math.max(items[i-1][1] ,items[i][1]);
        }

        int res[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            res[i] =binarySearch(items,queries[i]);
        }

        return res;

    }

    public int binarySearch(int[][] items, int price){

        int maxBeauty=0;

        int left=0;
        
        int right =items.length-1;

        while(left<=right){
            int mid =left +(right-left)/2;

            if(items[mid][0] <= price){
                maxBeauty =Math.max(maxBeauty,items[mid][1]);
                left =mid+1;
            }else{
                right=mid-1;
            }
        }

        return maxBeauty;

    }
    
}
