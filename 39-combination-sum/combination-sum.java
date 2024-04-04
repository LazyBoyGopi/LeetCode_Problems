class Solution {
    void backTrack(int[]candidates,int target,List<List<Integer>>result , List<Integer>temp,int sum,int idx)
    {
        if(sum == target)
        {
            result.add(new LinkedList<>(temp));
            return;
        }
        if(sum > target)
        {
            return;
        }
        for(int i=idx;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            backTrack(candidates,target,result,temp,sum+candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(candidates,target,result,new LinkedList<>(),0,0);
        return result;
    }
}