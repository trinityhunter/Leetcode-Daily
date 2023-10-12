/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int len = mountainArr.length()-1;

        int top = 0;

        int l = 0, r = len;

        while(l <= r){

            int mid = (l+r)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                r = mid-1;
            } 
            else{
                l = mid+1;
            }

        }

        top = l;

        l = 0;

        r = top;

        while(l <= r){

            int mid = (l+r)/2;

            int midvalue = mountainArr.get(mid);

            if(midvalue == target){
                return mid;
            }

            if(midvalue > target){
                r = mid-1;
            } 
            else{
                l = mid+1;
            }

        }

        l = top+1;

        r = len;

        while(l <= r){

            int mid = (l+r)/2;

            int midvalue = mountainArr.get(mid);
            if(midvalue == target){
                return mid;
            }

            if(midvalue > target){
                l = mid+1;
            } 
            else{
                r = mid-1;
            }

        }

        return -1;

    }
    
}
