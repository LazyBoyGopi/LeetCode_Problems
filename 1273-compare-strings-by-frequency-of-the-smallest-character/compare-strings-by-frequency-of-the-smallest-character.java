class Solution {
    private int binarySearch(int[]ar,int tar){
        int st = 0 , end = ar.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(ar[mid] <= tar) st = mid+1;
            else end = mid-1;
        }
        return ar.length-end-1;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int ql = queries.length;
        int wl = words.length;
        int[] output = new int[ql];
        int[] w = new int[wl];

        for(int i=0;i<wl;i++){
            w[i] = frequencyOfTheLexicographicallySmallestCharacter(words[i]);
        }
        Arrays.sort(w);
        for(int i=0;i<ql;i++){
            int curRem = frequencyOfTheLexicographicallySmallestCharacter(queries[i]);
            output[i] = binarySearch(w,curRem);
        }
        return output;
    }
    private int frequencyOfTheLexicographicallySmallestCharacter(String str){
        char ch = str.charAt(0);
        int count = 0;
        for(int i=0;i<str.length();i++){
            char curCh =  str.charAt(i);
            if(ch == curCh) count++;
            else if(ch > curCh){
                ch = curCh;
                count = 1;
            }
        }
        return count;
    }
}