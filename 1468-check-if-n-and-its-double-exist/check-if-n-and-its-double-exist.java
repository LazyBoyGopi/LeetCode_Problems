class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer>set = new HashSet();
        int zeroCount = 0;
        for(int ele : arr) {
            int doubleVal = ele*2;
            if(set.contains(doubleVal)) return true;
            set.add(ele);
            if(ele == 0) zeroCount++;
        }
        if(zeroCount > 1) return true;
        for(int ele : arr){
            if(ele == 0) continue;
            int doubleVal = ele*2;
            if(set.contains(doubleVal)) return true;
        }
        return false;
    }
}