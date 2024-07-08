class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer>list = new LinkedList<>();
        for(int i=1;i<=n;i++) list.add(i);
        int stIdx = 0;
        while(list.size() != 1){
            int removeIdx  = k+stIdx-1;
            if(removeIdx >= list.size()){
                int count = k;
                removeIdx = stIdx;
                while(count > 1){
                    removeIdx = (removeIdx+1 >= list.size()) ? 0 : removeIdx+1;
                    count--;
                }
            } 
            stIdx = (removeIdx == list.size()-1) ? 0 : removeIdx;
            list.remove(removeIdx);
        }
        return list.get(0);
    }
}