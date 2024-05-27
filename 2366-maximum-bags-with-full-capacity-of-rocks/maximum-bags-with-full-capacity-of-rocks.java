class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++){
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int count = 0;
        for(int i=0;i<capacity.length;i++){
            if(additionalRocks >= capacity[i])
            {
                additionalRocks -= capacity[i];
                count++;
            }
        }
    return count;



        // int[][]ar = new int[rocks.length][2];
        // for(int i = 0;i<rocks.length;i++){
        //     ar[i][1] = capacity[i];
        //     ar[i][0] = rocks[i];
        // }
        // Arrays.sort(ar,(a,b) -> Integer.compare(a[0],b[0]));
        // int count = 0;
        // System.out.println(Arrays.deepToString(ar));
        // for(int i=capacity.length-1;i>=0 && additionalRocks >= 0;i--){
        //     System.out.println(additionalRocks);
        //     if(ar[i][1] == ar[i][0]) count++;
        //     else {
        //         int dif = ar[i][1]-ar[i][0];
        //         if(additionalRocks >= dif){
        //             additionalRocks -= dif;
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}