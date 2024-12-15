class Solution {
    private class Pair{
        double gain;
        int idx;
        public Pair(double _gain,int _idx){
            gain = _gain;
            idx = _idx;
        }
    }
    private double calculateGain(double pass,double total){
        double before = pass/total;
        double after = (pass+1)/(total+1);
        return after-before;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<Pair>queue = new PriorityQueue<>((a,b)->Double.compare(b.gain,a.gain));
        int len = classes.length;
        for(int i=0;i<len;i++){
            int pass = classes[i][0];
            int total = classes[i][1];
            double gain = calculateGain(pass,total);
            Pair pair = new Pair(gain,i);
            queue.offer(pair);
        }
        while(extraStudents > 0){
            Pair pair = queue.poll();
            int idx = pair.idx;
            int pass = classes[idx][0]++;
            int total = classes[idx][1]++;
            double gain = calculateGain(pass+1,total+1);
            Pair newPair = new Pair(gain,idx);
            queue.offer(newPair);
            extraStudents--;
        }
        double averageRatio = 0.0;
        for(int i=0;i<len;i++){
            averageRatio += (double)classes[i][0]/classes[i][1];
        }
        averageRatio /= len;
        return Math.round(averageRatio * 100000.0)/100000.0;
    }
}