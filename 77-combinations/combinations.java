class Solution {
    private void recu(int n,int k,int idx,List<Integer>temp,List<List<Integer>>list){
        if(temp.size() == k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<=n;i++){
            temp.add(i);
            recu(n,k,i+1,temp,list);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        recu(n,k,1,new LinkedList<>(),list);
        return list;
    }
}