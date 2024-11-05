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
        int[]ar = new int[26];
        for(int i=0;i<str.length();i++){
            ar[str.charAt(i) - 'a']++;
        }
        for(int ele : ar){
            if(ele != 0) return ele;
        }
        return -1;
    }
}