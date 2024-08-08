class Solution {
    private int getMax(int[]nums){
        int max = -1;
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[getMax(nums)+1];
        for(int ele : nums){
            freq[ele]++;
        }
        int freqEle = -1;
        int times = 0;
        for(int i=0;i<freq.length;i+=2){
            if(freq[i] > times){
                times = freq[i];
                freqEle = i;
            }
        }
        return freqEle;
    }
}