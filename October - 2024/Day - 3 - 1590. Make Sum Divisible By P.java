class Solution {
    public int minSubarray(int[] num, int p) 
    {
        int n = num.length;
        long sum = 0;

        for (int val : num) 
        {
            sum += val;
        }

        long rem = sum % p;
        if (rem == 0) 
        {
            return 0;
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long pre = 0;
        int min = n;

        for (int i = 0; i < n; i++) 
        {
            pre += num[i];
            long cur = pre % p;

            long tar = (cur - rem + p) % p;

            if (map.containsKey(tar)) 
            {
                min = Math.min(min, i - map.get(tar));
            }

            map.put(cur, i);
        }

        if (min == n) 
        {
            return -1;
        } 
        else 
        {
            return min;
        }
    }
}
