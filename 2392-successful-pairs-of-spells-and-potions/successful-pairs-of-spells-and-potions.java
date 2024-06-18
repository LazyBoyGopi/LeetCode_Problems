class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length , m = potions.length;
        for(int i=0;i<n;i++){
            int st = 0 , end = m-1;
            while(st <= end){
                int mid = st+(end-st)/2;
                if((long)spells[i]*potions[mid] >= success) end = mid-1;
                else st = mid+1;
            }
            spells[i] = m-st;
        }
        return spells;
    }
}