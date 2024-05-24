class Solution {
    public int maximumScore(int a, int b, int c) {
        int score = 0;
        Queue<Integer>q = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(a);
        q.add(b);
        q.add(c);
        while(q.size() > 1){
            int n1 = q.poll()-1;
            int n2 = q.poll()-1;
            if(n1 > 0)
                q.add(n1);
            if(n2 > 0)
                q.add(n2);
            score++;
        }
        return score;
    }
}