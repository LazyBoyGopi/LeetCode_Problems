class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer>set = new HashSet<>();
        int sum = 0, count = 0;
        for(int i=1;count < n;i++){
            int comp = k-i;
            if(!set.contains(comp)){
                set.add(i);
                sum += i;
                count++;
            }
        }
        return sum;
    }
}