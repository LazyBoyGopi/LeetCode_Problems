class CustomStack {
    List<Integer>stack;
    int maxSize1;
    public CustomStack(int maxSize) {
        stack = new ArrayList();
        maxSize1 = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < maxSize1)
            stack.add(x);
    }
    
    public int pop() {
        if(stack.size()>0)
        {
            int val =  stack.remove(stack.size()-1);
            return val;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int min = Math.min(k,stack.size());
        for(int i=0;i<min; i++){
            stack.set(i,stack.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */