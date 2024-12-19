class Solution {
    public int maxChunksToSorted(int[] arr) {
        int min = -1,max = arr[0];
        Set<Integer>set = new HashSet<Integer>();
        int countOfpartitions = 0;
        for(int i=0;i<arr.length;i++){
            int curEle = arr[i];
            set.add(curEle);
            max = Math.max(curEle,max);
            boolean isEveryNumberPresent = true;
            for(int j=min+1;j<=max;j++){
                if(!set.contains(j)) {
                    isEveryNumberPresent = !isEveryNumberPresent;
                    break;
                }
            }
            if(isEveryNumberPresent){
                min = max;
                max = max+1;
                set.clear();
                countOfpartitions++;
            }
        }
        return countOfpartitions;
    }
}