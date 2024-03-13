class Solution {
    void swap(int[]nums,int first, int second)
    {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int missingNumber(int[] ar) {
        int xor = 0;
        for(int i=0;i<ar.length;i++)
        {
            xor ^= ar[i];
            xor ^= i+1;
        }
        // xor ^= ar.length+1;
        // xor1 ^= ar.length;
        return xor;
        // boolean ans[] = new boolean [nums.length+1];
        // for(int  n: nums) ans[n] = true;
        // for(int i=0;i<ans.length;i++) if(!ans[i]) return i;
        // int sum = 0;
        // boolean isZeroPresent = false;
        // for(int ele : nums)
        // {
        //     if(ele == 0) isZeroPresent = true;
        //      sum += ele;
        // }
        // int n = nums.length;
        // int totalSum = (n*(n+1))/2;
        // int ans = totalSum - sum;
        // if(isZeroPresent)
        // {
        //     if(ans == 0) return n+1;
        //     else return ans;
        // }
        // else return ans;


    // return 0;
        // int i =0;
        // while(i<nums.length)
        // {
        //     int correct = nums[i];
        //     if(correct != nums.length && nums[i] != nums[correct])
        //        swap(nums,i,correct);
        //        else i++;
        // }

        // for(i=0;i<nums.length;i++)
        // {
        //     if(nums[i] != i) return i;
        // }
        // return nums.length;













    //     //Sort nums using Cyclic Sort
    //     int i = 0;
    //     while(i<nums.length)
    //     {
    //         int correct = nums[i]
    //         ;
    //         if(nums[i] != nums[correct])
    //         swap(nums,i,correct);
    //         else i++;
    //     }

    //     for( i=0;i<nums.length;i++)
    //     {
    //         if(nums[i]!=i) return  i;
    //     }
    //     return nums.length;





        // int curSum =0,max = Integer.MIN_VALUE;
        // boolean found = false;
        // for(int n : nums) 
        // {
        //     curSum+=n;
        //     max = Math.max(max,n);
        //     if(n==0) found = true;
        // }
        // int maxSum = (max*(max+1))/2;
        // int ans =  maxSum - curSum;
        //  if(ans == 0)
        //  {
        //      if(found)
        //      return max+1;
        //      return 0;
        //  } 
        // return ans;
    }
}