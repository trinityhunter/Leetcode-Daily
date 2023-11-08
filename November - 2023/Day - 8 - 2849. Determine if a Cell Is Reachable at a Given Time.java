class Solution {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

        int maxi = Math.max(Math.abs(fx - sx), Math.abs(fy - sy));

        return !(maxi > t || (maxi == 0 && t == 1));

    }
    
}
