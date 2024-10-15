class Solution {
    private void swap(char[]ar,int i,int j){
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public long minimumSteps(String s) {
        long minSwaps = 0l;
        char[]ar = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right){
            while(left < right && ar[left] == '0') left++;
            while(left < right && ar[right] == '1') right--;
            if(left < right){
                minSwaps += (right-left);
                swap(ar,left,right);
                left++;
                right--;
            }
        }
        return minSwaps;
    }
}