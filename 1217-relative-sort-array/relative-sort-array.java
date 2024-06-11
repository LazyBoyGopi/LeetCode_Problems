class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[]freq = new int[1001];
        for(int ele : arr1) freq[ele]++;

        int idx = 0;
        for(int ele : arr2){
            while(freq[ele] > 0){
                arr1[idx++] = ele;
                freq[ele]--;
            }
        }
        for(int i=0;i<freq.length;i++){
            while(freq[i] > 0){
                arr1[idx++] = i;
                freq[i]--;
            }
        }
        return arr1;
    }
}