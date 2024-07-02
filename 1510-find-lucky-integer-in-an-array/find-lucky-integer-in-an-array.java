class Solution {
    public int findLucky(int[] arr) {
        int[]ar = new int[501];
        for(int ele : arr) ar[ele]++;
        for(int i=ar.length-1;i>0;i--){
            if(ar[i] == i) return i;
        }
        return -1;
    }
}