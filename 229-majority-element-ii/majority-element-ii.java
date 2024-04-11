class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0 , c2 = 0;
        int e1 =Integer.MIN_VALUE, e2= Integer.MIN_VALUE;
        for(int ele : nums)
        {
            if(c1 == 0 && ele != e2)
            {
                c1 = 1;
                e1 = ele;
            }
            else if(c2 == 0 && ele != e1)
            {
                c2 = 1;
                e2 = ele;
            }
            else if(ele == e1) c1++;
            else if(ele == e2) c2++;
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int ele : nums)
        {
            if(ele == e1) c1++;
            else if(ele == e2) c2++;
        }
        List<Integer> list = new LinkedList<>();
        if(c1 >= (nums.length/3)+1) list.add(e1);
        if(c2 >= (nums.length/3)+1) list.add(e2);
        return list;
    }
}