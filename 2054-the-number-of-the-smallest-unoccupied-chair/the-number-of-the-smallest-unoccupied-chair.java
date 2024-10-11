class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> leavingTime = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        Queue<Integer>availableChairs = new PriorityQueue<>();
        int len = times.length;
        
        int targetFrndArriveTime = times[targetFriend][0];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));

        int chair = 0;

        for(int i=0;i<len;i++){
            int time[] = times[i];
            int arriveTime = time[0];
            while(!leavingTime.isEmpty() && leavingTime.peek()[0] <= arriveTime) {
                availableChairs.add(leavingTime.poll()[1]);
            }

            int curChair;
            if(!availableChairs.isEmpty()) {
                curChair = availableChairs.poll();
            }else{
                curChair = chair++;
            }

            leavingTime.add(new int[]{time[1],curChair});
            
            if(targetFrndArriveTime == arriveTime) return curChair;
        }
        return -1;
    }
}