class Solution {
    public long dividePlayers(int[] skill) {
        long chemistry = 0;
        int []freq = new int[1001];
        int len = skill.length;
        long sum = 0;
        for(int i=0;i<len;i++){
            sum += skill[i];
            freq[skill[i]]++;
        }
        int targetSkill = (int) (sum/(len/2));

        for(int i=0;i<1001;i++){
            if(freq[i] == 0) continue;
            int target = Math.abs(targetSkill-i);
            if(target > 1000) return -1;
            if(i == target){
                if(freq[target] % 2 == 0) {
                    chemistry += (((long)(i*target))*freq[target]/2);
                    freq[target] = 0;
                }
                else return -1;
            }else{
                if(freq[i] == freq[target]) {
                chemistry += (i*target)*freq[target];
                    freq[i] = 0;
                    freq[target] = 0;
                }
                else return -1;
            }
            
        }
        return chemistry;
    }
}