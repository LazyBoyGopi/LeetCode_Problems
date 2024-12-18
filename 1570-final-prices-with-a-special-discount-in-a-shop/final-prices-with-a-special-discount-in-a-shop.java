class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        for(int i=0;i<len;i++){
            int idx = -1;
            int curPrice = prices[i];
            for(int j=i+1;j<len;j++){
                if(prices[j] <= curPrice){
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}