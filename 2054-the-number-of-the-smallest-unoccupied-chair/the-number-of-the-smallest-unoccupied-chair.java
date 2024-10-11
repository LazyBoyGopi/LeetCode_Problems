class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> leavingTime = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        Queue<Integer>availableChairs = new PriorityQueue<>();
        for(int i=0;i<times.length;i++){
            availableChairs.add(i);
        }
        int targetFrndArriveTime = times[targetFriend][0];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));

        for(int time[] : times){
            while(!leavingTime.isEmpty() && leavingTime.peek()[0] <= time[0]) {
                availableChairs.add(leavingTime.poll()[1]);
            }
            int curChair = availableChairs.poll();
            leavingTime.add(new int[]{time[1],curChair});
            if(targetFrndArriveTime == time[0]) return curChair;
        }
        return -1;
    }
}