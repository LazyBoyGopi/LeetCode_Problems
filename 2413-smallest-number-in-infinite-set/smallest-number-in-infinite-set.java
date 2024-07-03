class SmallestInfiniteSet {
    Queue<Integer>q ;
    Set<Integer>set;
    int cur;
    public SmallestInfiniteSet() {
        q = new PriorityQueue();
        set = new HashSet();
        cur = 1;
    }
    
    public int popSmallest() {
        if(!q.isEmpty()){
            int ele = q.poll();
            set.remove(ele);
            return ele;
        }
        return cur++;
    }
    
    public void addBack(int num) {
        if(num < cur && set.add(num)) q.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */