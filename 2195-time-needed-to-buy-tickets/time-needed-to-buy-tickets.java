class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        List<Integer> q = new LinkedList<>();
        for(int ele : tickets) q.add(ele);
        int time = 0;
        while(q.size() > 0 && q.get(k) > 0)
        {
            int ele = q.remove(0)-1;
            time++;
            if(k == 0 && ele == 0) return time;
            if(ele > 0)
            q.add(ele);
            if(k > 0)
            k--;
            else k = q.size()-1;
        }
        return time;
    }
}