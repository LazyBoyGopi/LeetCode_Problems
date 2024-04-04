class Solution {
    void backTrack(int[]nums,List<List<Integer>>list ,List<Integer>temp)
    {
        if(temp.size() == nums.length)
        {
            list.add(new LinkedList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backTrack(nums,list,temp);
            temp.remove(temp.size()-1);
        }
    }
    // void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result) {
    //     if (temp.size() == nums.length) {
    //         result.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (temp.contains(nums[i]))
    //             continue;
    //         temp.add(nums[i]);
    //         backtrack(nums, temp, result);
    //         temp.remove(temp.size() - 1);
    //     }
    // }
    void recur(int[]nums,int fi,List<List<Integer>>result)
    {
        if(fi == nums.length)
        {
            List<Integer> list = new LinkedList<>();
            for(int ele : nums) list.add(ele);
            result.add(list);
            return;
        }
        for(int i=fi;i<nums.length;i++)
        {
            swap(nums,i,fi);
            recur(nums,fi+1,result);
            swap(nums,i,fi);
        }
    }
    void swap(int[]nums,int i,int fi)
    {
        int temp = nums[i];
        nums[i] = nums[fi];
        nums[fi] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(nums,result,new ArrayList<>());
        // recur(nums,0, result);
        return result;
    }
}