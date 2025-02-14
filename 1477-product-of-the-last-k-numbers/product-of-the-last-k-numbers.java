class ProductOfNumbers {
    List<Integer>list;
    public ProductOfNumbers() {
        list = new ArrayList();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int len = list.size();
        int ans = 1;
        for(int i=len-1;i >= len-k;i--){
            ans *= list.get(i);
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */