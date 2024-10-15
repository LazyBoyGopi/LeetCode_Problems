class Solution {
    private void swap(char[]ar,int i,int j){
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public long minimumSteps(String s) {
        long minSwaps = 0;
        int right = s.length()-1;
        int left = right;
        char []ar = s.toCharArray();
        while(left >= 0){
            while(right >= 0 && ar[right] == '1') right--;
            if(left >= right){
                left = right-1;
            }
            while(left >= 0 && ar[left] == '0') left--;
            if(left >= 0){
                swap(ar,left,right);
                minSwaps += right-left;
            }
            --right;
        }
        return minSwaps;
    }
}