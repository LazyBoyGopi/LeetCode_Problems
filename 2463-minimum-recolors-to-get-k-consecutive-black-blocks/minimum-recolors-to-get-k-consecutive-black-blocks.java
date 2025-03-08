class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wCount = 0, n = blocks.length();
        for(int i=0;i<k;i++){
            if(blocks.charAt(i) == 'W')
                wCount++;
        }
        int minChanges = wCount;
        for(int i=k;i<n;i++){
            if(blocks.charAt(i-k) == 'W')
                wCount--;
            if(blocks.charAt(i) == 'W')
                wCount++;
            minChanges = Math.min(minChanges,wCount);
        }
        return minChanges;
    }
}