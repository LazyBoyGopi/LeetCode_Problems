class Solution {
    public boolean checkIfExist(int[] arr) {
       Set<Integer> set = new HashSet();
       for(int ele : arr){
        if(set.contains(ele*2) || (ele %2 == 0 && set.contains(ele/2))) {
            return true;
        }
        set.add(ele);
       }
       return false;
    }
}