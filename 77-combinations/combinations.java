class Solution {
    private void recu(int[]ar,int k,int idx,List<Integer>temp,List<List<Integer>>list){
        if(temp.size() > k) return;
        if(temp.size() == k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<ar.length;i++){
            temp.add(ar[i]);
            recu(ar,k,i+1,temp,list);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        int[]ar = new int[n];
        for(int i=1;i<=n;i++){
            ar[i-1] = i;
        }
        recu(ar,k,0,new LinkedList<>(),list);
        return list;
    }
}