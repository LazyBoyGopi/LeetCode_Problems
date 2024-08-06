class Solution {
    public int minimumPushes(String word) {
        int[]ar = new int[26];
        for(char ch : word.toCharArray()){
            ar[ch-'a']++;
        }
        Arrays.sort(ar);
        int totalCount = 0;
        int setCount = 1 , count = 0;
        for(int i=ar.length-1;i>=0;i--){
            totalCount += (ar[i]*setCount);
            count++;
            if(count == 8){
                setCount++;
                count = 0;
            }
        }
        return totalCount;
    }
}