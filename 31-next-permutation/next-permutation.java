class Solution {
    private void reverse(int[]nums,int st,int end)
    {
        while(st <= end)
        {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1])
            {
                idx = i;
                break;
            }
        }
        if(idx == -1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        else{
            int j = nums.length-1;
            while(j >= idx)
            {
             if(nums[j] > nums[idx])
             {
                int temp = nums[idx];
                nums[idx] = nums[j];
                nums[j] = temp;
                break;
             }   
             j--;
            }
            reverse(nums,idx+1,nums.length-1);
            return;
        }
    }
}