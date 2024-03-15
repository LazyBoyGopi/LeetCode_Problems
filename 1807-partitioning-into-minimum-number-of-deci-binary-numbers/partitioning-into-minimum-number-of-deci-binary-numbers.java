class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i=0;i<n.length();i++)
        {
            int cur = Integer.parseInt(n.charAt(i)+"");
            max = Math.max(cur,max);
        }
        return max;
    }
}