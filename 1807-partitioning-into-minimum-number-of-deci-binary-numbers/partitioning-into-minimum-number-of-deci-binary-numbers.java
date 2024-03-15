class Solution {
    public int minPartitions(String n) {
        char max = '0';
        for(int i=0;i<n.length();i++)
        {
            char cur = n.charAt(i);
            if(cur > max) max = cur;
        }
        return Integer.parseInt(max+"");
    }
}