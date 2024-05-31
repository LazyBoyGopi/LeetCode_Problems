class Solution {
    public int longestOnes(int[] ar, int k) {
        int left = 0 , right = 0 , len = ar.length , max = 0 , count = 0;
        while(right < len){
            if(ar[right++] == 0) count++;

            while(count > k && left < right){
                max = Math.max(max,right-left-1);
                if(ar[left] == 0) count--;
                left++;
            }
        }
        return Math.max(max,right-left);
    }
}