class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0 , len = arr.length;
        for(int i=0;i<len;i++){
            int left = i+1;
            int right = len-i;

            int total = left*right;

            int subArray =(total+1)/2;
            ans += arr[i]*subArray;
        }
        return ans;
    }
}