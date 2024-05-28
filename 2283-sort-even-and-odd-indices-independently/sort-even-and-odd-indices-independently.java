class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer>odd = new LinkedList<>() , even = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(i %2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        int idx = 0 , idx2 = odd.size()-1;
        Collections.sort(odd);
        Collections.sort(even);
        for(int i=0;i<nums.length;i++){
            if(i %2 == 0)
                nums[i] = even.get(idx++);
            else
                nums[i] = odd.get(idx2--);
        }
        return nums;
    }
}