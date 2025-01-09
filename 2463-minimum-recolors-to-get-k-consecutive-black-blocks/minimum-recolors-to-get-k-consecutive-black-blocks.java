class Solution {
    public int minimumRecolors(String blocks, int k) {
        int max = 0, len = blocks.length();
        for(int i=0;i<len;i++){
            int countOfBlacks = 0;
            for(int j=i;j<len;j++){
                if(blocks.charAt(j) == 'B') countOfBlacks++;
                if(j - i+1 == k) {
                    break;
                }
            }
            max = Math.max(max,countOfBlacks);
        }
        return k-max;
    }
}