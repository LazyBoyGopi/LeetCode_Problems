class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        int i = 0;
        while ( i < nums.length) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    int temp = nums[j];
                    while (j < k && nums[j] == temp) {
                        j++;
                    }
                    while (j < k && nums[k] == temp) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else
                    j++;
            }
            int temp = nums[i];
            while(i < nums.length && nums[i] == temp)
            {
                i++;
            }
        }
        return list;

        // List<List<Integer>> list = new LinkedList<>();
        // for(int i=0;i<nums.length;i++)
        // {
        // Set<Integer> set = new HashSet();
        // for(int j=i+1;j<nums.length;j++)
        // {
        // int third = -(nums[i]+nums[j]);
        // if(set.contains(third))
        // {
        // List<Integer>temp = new LinkedList<>();
        // temp.add(third);
        // temp.add(nums[i]);
        // temp.add(nums[j]);
        // Collections.sort(temp);
        // if(!list.contains(temp)) list.add(temp);
        // }
        // set.add(nums[j]);
        // }
        // }
        // return list;
        // Set<List<Integer>> list = new HashSet<>();
        // for(int i=0;i<nums.length-2;i++)
        // {
        // for(int j=i+1;j<nums.length-1;j++)
        // {
        // for(int k=j+1;k<nums.length;k++)
        // {
        // if(nums[i] + nums[j] + nums[k] == 0) {
        // List<Integer> l = Arrays.asList(nums[i],nums[j],nums[k]);
        // Collections.sort(l);
        // // if(!list.containsAll(l))
        // list.add(l);
        // }
        // }
        // }
        // }
        // List<List<Integer>> l = new LinkedList<>(list);
        // return l;
    }
}