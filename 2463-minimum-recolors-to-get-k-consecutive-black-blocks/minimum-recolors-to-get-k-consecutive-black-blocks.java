class Solution {
    public int minimumRecolors(String blocks, int k) {
        int max = 0, len = blocks.length();
        int count = 0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i) == 'B') count++;
        }
        max = Math.max(max,count);
        for(int i=k;i<len;i++){
            if(blocks.charAt(i-k) == 'B') count--;
            if(blocks.charAt(i) == 'B') count++;
            max = Math.max(max,count);
        }
        return k-max;
    }
}