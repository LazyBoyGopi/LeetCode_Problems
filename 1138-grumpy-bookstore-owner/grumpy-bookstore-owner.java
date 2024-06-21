class Solution {
    private int[]getIdxForRange(int[]customers,int[]grumpy,int minutes){
        int[]idx = {-1,-1};
        int left = 0 , noOfGrumpy = 0 , max = 0 , sum = 0 , maxGrumpy = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1) {
                noOfGrumpy++;
                sum += customers[i];
            }
        }
        if(noOfGrumpy > 0){
            maxGrumpy = noOfGrumpy;
            max = sum;
            idx[0] = 0;
            idx[1] = minutes-1;
        }
        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i-minutes] == 1) {
                noOfGrumpy--;
                sum -= customers[i-minutes];
            }
            if(grumpy[i] == 1) {
                noOfGrumpy++;
                sum += customers[i];
            }
            if(grumpy[i] == 1 && (sum > max)){
                maxGrumpy = noOfGrumpy;
                max = sum;
                idx[0] = i-minutes+1;
                idx[1] = i; 
            }
        }
        return idx;
    }
    private int getAns(int[]customers,int[]grumpy,int[]idx){
        int max = 0 , st = idx[0] , end = idx[1];
        for(int i=0;i<customers.length;i++){
            if(grumpy[i] == 0 ||(st==-1 || (i>=st && i<= end))){
                max += customers[i];
            }
        }
        return max;
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[]idx = getIdxForRange(customers,grumpy,minutes);
        return getAns(customers,grumpy,idx);
    }
}