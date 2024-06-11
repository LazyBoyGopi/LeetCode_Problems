class Solution {
    public boolean checkIfExist(int[] arr) {
        int idx = 0;
       Set<Integer> set = new HashSet();
       for(int ele : arr){
        if(set.contains(ele*2) || (ele %2 == 0 && set.contains(ele/2))) {
            return true;
        }
        set.add(ele);
        idx++;
       }
       return false;
    }
}