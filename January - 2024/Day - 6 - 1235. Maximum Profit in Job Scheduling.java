class Job{

    int start;
    int end;
    int recompense;

    public Job(int start, int end, int recompense) {
        this.start = start;
        this.end = end;
        this.recompense = recompense;
    }

}

public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit){

        int n = startTime.length;

        Job[] jobsArr = new Job[n];
        
        for(int i=0; i<n; i++){
            jobsArr[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobsArr, (a, b) -> Integer.compare(a.end, b.end));
        
        int[] earnings = new int[n+1];

        Arrays.fill(earnings, 0);

        for (int i=0; i<n; i++){

            Job job = jobsArr[i];

            int nonConflictIndex = Arrays.binarySearch(jobsArr, 0, i, job,
                (Job j, Job time) -> {
                    int result = Integer.compare(j.end, time.start);
                    return (result == 0) ? Integer.compare(j.start, time.start) : result;
                });

            nonConflictIndex = (nonConflictIndex < 0) ? -nonConflictIndex - 1 : nonConflictIndex;

            earnings[i + 1] = (earnings[i] > earnings[nonConflictIndex] + job.recompense) ?
                  earnings[i] : earnings[nonConflictIndex] + job.recompense;

        }

        return earnings[n];

    }
    
}
