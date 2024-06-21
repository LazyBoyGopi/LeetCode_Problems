class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0 , maxGrumpySum = 0 , curSum = 0 ,lastSum = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                curSum += customers[i];
            }
            else ans += customers[i];
        }
        if(maxGrumpySum < curSum){
            maxGrumpySum = curSum;
            ans += curSum;
            lastSum = curSum;
        }
        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i-minutes] == 1) curSum -= customers[i-minutes];
            if(grumpy[i] == 1) curSum += customers[i];
            else ans += customers[i];
            if(maxGrumpySum < curSum){
                ans -= lastSum;
                lastSum = curSum;
                ans += curSum;
                maxGrumpySum = curSum;
            }
            
        }
        return ans;
    }
}