class Solution {
    private int getAnswer(int[]nums,int k)
    {
        int count = 0;
        List<Integer> list = new LinkedList<>();
        for(int ele : nums) list.add(ele);
        while(true)
        {
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            boolean isPairPresent = false;
            for(int i=0;i<list.size();i++)
            {
                int comp = k-list.get(i);
                if(map.containsKey(comp))
                {
                    int ele = list.get(i);
                    list.remove((int)map.get(comp));
                    list.remove((Integer)ele);
                    map.remove(comp);
                    isPairPresent = true;
                    count++;
                    break;
                }
                else{
                    map.put(list.get(i),i);
                }
            }
            if(!isPairPresent) break;
        }
        return count;
    }
    private int getAnswer1(int[]nums,int k)
    {
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == -1) continue;
            for(int j=i+1;j<nums.length;j++)
            {
                if((nums[i] != -1 && nums[j] != -1) && nums[i] + nums[j] == k)
                {
                    nums[i] = -1;
                    nums[j] = -1;
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
    private int getAnswer2(int[]nums,int k)
    {
        Map<Integer,Integer>map = new HashMap<>();
        int count = 0;
        for(int ele : nums)
        {
            int comp = k-ele;
            if(map.containsKey(comp))
            {
                if(map.get(comp) == 1) map.remove(comp);
                else map.put(comp,map.get(comp)-1);
                count++;
            }
            else map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return count;
    }
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int st = 0 , end = nums.length-1;
        while(st < end)
        {
            int sum = nums[st] + nums[end];
            if(sum == k) {
                st++;
                end--;
                count++;
            }
            else if(sum > k) end--;
            else st++;
        }
        return count;
    }
}