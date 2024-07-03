class SmallestInfiniteSet {
    Queue<Integer>q ;
    Set<Integer>set;
    public SmallestInfiniteSet() {
       q = new PriorityQueue(1000);
       set = new HashSet<>();
       for(int i=1;i<=1000;i++){
            set.add(i);
            q.add(i);
       }
    }
    
    public int popSmallest() {
        int ele = q.poll();
        set.remove(ele);
        return ele;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            q.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */