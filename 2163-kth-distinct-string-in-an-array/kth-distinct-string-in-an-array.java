class Solution {
    public String kthDistinct(String[] arr, int k) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            boolean isFound = false;
            for(int j=0;j<arr.length;j++){
                if(j == i) continue;
                if(arr[i].equals(arr[j])){
                    isFound = true;
                    break;
                }
            }
            if(!isFound) count++;
            if(count == k) return arr[i];
        }
        return "";
    }
}