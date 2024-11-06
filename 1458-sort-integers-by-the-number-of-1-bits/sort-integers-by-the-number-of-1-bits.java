class Solution {
    public int[] sortByBits(int[] arr) {
        int[][]ar = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            ar[i][0] = Integer.bitCount(arr[i]);
            ar[i][1] = arr[i];
        }
        Arrays.sort(ar,(a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<arr.length;i++){
            arr[i] = ar[i][1];
        }
        return arr;
    }
}