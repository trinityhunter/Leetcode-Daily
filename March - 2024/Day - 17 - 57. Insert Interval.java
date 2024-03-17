class Solution {

    public int[][] merge(int[][] intervals) {

		if(intervals.length <= 1){
			return intervals;
        }
            
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> ans = new ArrayList<>();

		int[] arr = intervals[0];

		ans.add(arr);

		for(int[] interval :intervals){
			if(interval[0] <= arr[1]){
				arr[1] = Math.max(arr[1], interval[1]);
            }
			else {                             
				arr = interval;
				ans.add(arr);
			}
		}

		return ans.toArray(new int[ans.size()][]);

	}

    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] arr = new int[intervals.length+1][2];

        for(int i=0; i<intervals.length; i++){
            arr[i] = intervals[i];
        }

        arr[arr.length-1] = newInterval;

        return merge(arr);

    }

}
