class MyCalendarTwo {

    List<int[]> arr1;

    List<int[]> arr2;

    public MyCalendarTwo() {

        arr1 = new ArrayList<>();

        arr2 = new ArrayList<>();  

    }
    
    public boolean book(int start, int end) {

        for(int[] val: arr2){
            if(end >val[0] && start <val[1]){
                return false;
            }
        }

        for(int[] val: arr1){
            if(end >val[0] && start <val[1]){
               arr2.add(new int[]{Math.max(start,val[0]), Math.min(end, val[1])});
            }
        }

        arr1.add(new int[]{start,end});

        return true;

    }

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
