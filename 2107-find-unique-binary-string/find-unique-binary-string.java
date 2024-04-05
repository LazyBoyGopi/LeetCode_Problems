class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            sb.append("1");
        }
        String s = sb.toString();
        int idx = 0;
        int ones = 0;
        while(true)
        {
            
            boolean flag = true;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i].equals(s))
                {
                    flag = false;
                    break;
                }
            }
            if(flag) break;
            else{
                char[]ar = s.toCharArray();
            if(ar[idx] == '1')
            {
                ar[idx] = '0';
                ones++;
            }
            else{
                ar[idx] = '1';
                ones++;
            }
            if(ones == 2)
            {
                ones =0;
                idx++;
            }
            s = new StringBuilder().append(ar).toString();
            }
        }
        return s;
    }
}