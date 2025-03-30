class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len-2;i++){
            if((arr[i] & 1) == 1 && (arr[i+1] & 1) == 1 && (arr[i+2] & 1) == 1) return true;
        }
        return false;
    }
}