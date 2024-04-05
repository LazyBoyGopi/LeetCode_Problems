class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            sb.append('0');
        }
        String s = sb.toString();
        int idx = 0;
        int times = 0;
        while(true)
        {
            boolean flag = true;
            for(String str : nums)
            {
                if(str.equals(s)){
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
                    times++;
                }
                else{
                    ar[idx] ='1';
                    times++;
                }
                if(times == 2)
                {
                    idx++;
                    times=0;
                }
                s = new StringBuilder().append(ar).toString();
            }
        }
        return s;
    }
}