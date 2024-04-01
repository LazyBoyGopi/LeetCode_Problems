class Solution {
    public int getWinner(int[] arr, int k) {
        int max = 0;
        List<Integer> q = new LinkedList<>();
        for(int ele : arr) {
            q.add(ele);
            max = Math.max(max,ele);
        }
        if(k >= arr.length)
        return max;
        int lastEle = 0;
        int countOfWins = 0;
        while(true)
        {
            if(q.get((int)0) > q.get((int)1))
            {
                if(lastEle == q.get((int)0))
                {
                    countOfWins++;
                }
                else{
                    lastEle = q.get((int)0);
                    countOfWins =1;
                }
                q.add(q.remove((int)1));
            }
            else{
                if(lastEle == q.get((int)1))
                {
                    countOfWins++;
                }
                else{
                    lastEle = q.get((int)1);
                    countOfWins =1;
                }
                q.add(q.remove((int)0));
            }
            if(countOfWins == k) break;
        }
        return lastEle;
    }
}