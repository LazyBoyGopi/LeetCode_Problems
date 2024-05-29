class Solution {
    private void flipAndInvert(int[][]image){
        for(int [] ar : image){
            int st = 0 , end = ar.length-1;
            while(st <= end){
                int temp = ar[st];
                ar[st++] = (ar[end] == 0) ? 1 : 0;
                ar[end--] = temp == 0 ? 1 : 0;
            }
        }
    }
    public int[][] flipAndInvertImage(int[][] image) {
        flipAndInvert(image);
        return image;
    }
}