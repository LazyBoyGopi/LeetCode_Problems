class Solution {
    public int minPartitions(String n) {
        char max = '0';
        for(int i=0;i<n.length();i++)
        {
            // char cur = ;
            if(n.charAt(i) > max) max = n.charAt(i);
        }
        return Integer.parseInt(max+"");
    }
}