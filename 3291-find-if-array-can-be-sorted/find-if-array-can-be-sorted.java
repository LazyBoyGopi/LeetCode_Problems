class Solution {
    /* private int countSetBits(int n){
        int count = 0;
        while(n > 1){
            if(n % 2 == 1) count++;
            n /= 2;
        }
        return n == 1? count+1 : count;
    } */
    private boolean isSorted(int[]nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
    private int maxFrom(int[]nums,int st,int end){
        int max = nums[st];
        for(int i=st+1;i<=end;i++) max = Math.max(max,nums[i]);
        return max;
    }
    private int minFrom(int[]nums,int[]ar,int st){
        int min = nums[st];
        for(int i=st+1;i<ar.length;i++){
            if(ar[st] == ar[i]) min = Math.min(min,nums[i]);
            else break;
        }
        return min;
    }
    public boolean canSortArray(int[] nums) {
        int len = nums.length;
        if(len == 1 || isSorted(nums)) return true;
        int[]ar = new int[len];

        for(int i=0;i<len;i++){
            /*
            * Integer.bitCount() method return number of '1' bits in the given number, if the given number is positive and return 2's complement if the given number is negative -> ( 2 -> 1 ) , (-2 -> 31) TC -> O(1)
            * Or call countSetBits() method TC-> O(logN);
             */

            ar[i] = Integer.bitCount(nums[i]);
        }
        int leftLast = 0;
        for(int i=0;i<len-1;i++){
            if(ar[i] != ar[i+1]){
                if(maxFrom(nums,leftLast,i) > minFrom(nums,ar,i+1)) return false;
                leftLast = i+1;
            }
        }
        System.out.println(Integer.bitCount(2));
        return true;
    }
}