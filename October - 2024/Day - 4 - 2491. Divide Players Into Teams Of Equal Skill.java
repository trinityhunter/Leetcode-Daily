class Solution {

    public long dividePlayers(int[] skill) {

        Arrays.sort(skill);

        HashSet<Long> set = new HashSet<>();

        long ans = 0;

        for(int i=0; i<skill.length/2; i++){
            set.add((long)(skill[i] + skill[skill.length-i-1]));
            ans += (skill[i] * skill[skill.length-i-1]);
        }

        if(set.size()!=1){
            return -1;
        }

        return ans;

    }

}
