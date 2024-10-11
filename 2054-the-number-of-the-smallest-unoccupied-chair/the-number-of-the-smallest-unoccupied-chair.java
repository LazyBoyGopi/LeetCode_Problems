class Solution {
    class Pair {
        public int time;
        public int chairNumber;

        public Pair(int leavingTime_, int chairNumber_) {
            time = leavingTime_;
            chairNumber = chairNumber_;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {

        Queue<Pair> leavingTimes = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        Queue<Integer> availableChairs = new PriorityQueue<>();
       for(int i=0;i<times.length;i++) availableChairs.add(i);
        int targetFrndArriveTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        int chairNum = 0;
        for (int[] time : times) {
            while (!leavingTimes.isEmpty() && leavingTimes.peek().time <= time[0]) {
                availableChairs.add(leavingTimes.poll().chairNumber);
            }
            int chairAval = availableChairs.poll();
            leavingTimes.add(new Pair(time[1],chairAval));
            if (targetFrndArriveTime == time[0]) {
                return chairAval;
            }
        }
        return -1;
    }
}