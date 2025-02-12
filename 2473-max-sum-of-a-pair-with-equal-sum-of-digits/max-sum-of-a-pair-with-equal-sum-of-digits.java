class Solution {
    private int calcSum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int[][]freq = new int[90][2];
        int len = nums.length;
        for(int i=0;i<len;i++){
            int curEle = nums[i];
            int sum = calcSum(curEle);
            int[] ar = freq[sum];
            if(ar[0] < curEle){
                ar[1] = ar[0];
                ar[0] = curEle;
            }else if(ar[1] < curEle){
                ar[1] = curEle;
            }
        }
        int maxSum = -1;
        for(int []ar : freq){
            if(ar[0] != 0 && ar[1] != 0){
                maxSum = Math.max(maxSum,ar[0]+ar[1]);
            }
        }
        return maxSum;
    }
}