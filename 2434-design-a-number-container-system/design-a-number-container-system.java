class NumberContainers {
    Map<Integer,Integer> res;
    Map<Integer,PriorityQueue<Integer>> indexes;
    public NumberContainers() {
        res = new HashMap();
        indexes = new HashMap();
    }
    
    public void change(int index, int number) {
        if(res.containsKey(index)){
            int num = res.get(index);
            if(num == number) return;
            indexes.get(num).remove(index);
        }
        indexes.computeIfAbsent(number,k->new PriorityQueue<Integer>()).offer(index);
        res.put(index,number);
    }
    
    public int find(int number) {
        Queue<Integer>q = indexes.getOrDefault(number,new PriorityQueue<Integer>());
        return q.isEmpty() ? -1 : q.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */