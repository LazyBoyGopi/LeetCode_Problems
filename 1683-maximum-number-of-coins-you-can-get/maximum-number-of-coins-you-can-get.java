class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int totalCoins = 0 , pile = 0;
        for(int i=piles.length-2;i+1>=pile;i-=2){
            totalCoins += piles[i];
            pile++;
        }
        return totalCoins;
    }
}