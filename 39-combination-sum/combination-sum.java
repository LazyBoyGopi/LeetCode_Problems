class Solution {
    void backTrack(int[]candidates,int target,List<List<Integer>>result , List<Integer>temp,int idx)
    {
        if(target == 0)
        {
            result.add(new LinkedList<>(temp));
            return;
        }
        for(int i=idx;i<candidates.length;i++)
        {
            if(target >= candidates[i])
            {
                temp.add(candidates[i]);
                backTrack(candidates,target-candidates[i],result,temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(candidates,target,result,new LinkedList<>(),0);
        return result;
    }
}