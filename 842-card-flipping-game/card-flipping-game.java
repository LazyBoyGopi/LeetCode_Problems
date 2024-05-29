 

 class Solution{
    public int flipgame(int[]fronts,int[]backs){
        Set<Integer>bad = new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i] == backs[i]) bad.add(fronts[i]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<fronts.length;i++){
            if(!bad.contains(fronts[i])) min = Math.min(min,fronts[i]);
            if(!bad.contains(backs[i])) min = Math.min(min,backs[i]);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
 }
  /*class Solution{
    public int flipgame(int[] fronts, int[] backs) {
        int[][]ar = new int[fronts.length][2];
        for(int i=0;i<fronts.length;i++){
            ar[i][0] = fronts[i];
            ar[i][1] = backs[i];
        }
        Arrays.sort(ar,(a,b) -> Integer.compare(a[0],b[0]));
        for(int eachAr[] : ar){
            if(eachAr[0] != eachAr[1]){
                boolean flag = true;
                for(int i=0;i<ar.length;i++){
                    if(ar[i][0] == eachAr[0] && ar[i][1] == eachAr[1]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) return eachAr[0];
            }
        }
        return 0;
    }
 }
 
 
 
 class Solution {
    int min = 0;
    private void swap(int[]fronts,int[]backs,int idx){
        int temp = fronts[idx];
        fronts[idx] = backs[idx];
        backs[idx] = temp;
    }
    private void flipTheCards(int[]fronts,int[]backs,int idx){
        if(idx == fronts.length){
            int count = 0;
            Set<Integer>set = new HashSet<>();
            for(int ele : fronts) set.add(ele);
            for(int i=0;i<backs.length;i++){
                if(!set.contains(backs[i])) min = Math.min(backs[i],min);
            }
            return;
        }
        swap(fronts,backs,idx);
        flipTheCards(fronts,backs,idx+1);
        swap(fronts,backs,idx);
        flipTheCards(fronts,backs,idx+1);
    }
    public int flipgame(int[] fronts, int[] backs) {
        min = Integer.MAX_VALUE;
        flipTheCards(fronts,backs,0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
} */