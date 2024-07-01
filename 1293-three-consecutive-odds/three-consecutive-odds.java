class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;
        int count = 0;
        for(int i=0;i<3;i++){
            if(arr[i] % 2 == 1) count++;
            else count = 0;
        }
        if(count == 3) return true;
        for(int i=3;i<arr.length;i++){
            if(arr[i] % 2 == 1) count++;
            else count = 0;
            if(count == 3) return true;
        }
        return false;
    }
}