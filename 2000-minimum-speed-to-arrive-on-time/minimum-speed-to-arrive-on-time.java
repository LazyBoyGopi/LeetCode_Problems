class Solution {
    private int findMax(int[]dist){
        int max = 0;
        for(int ele : dist) if(max < ele) max = ele;
        return max;
    }
    private boolean isPossible(int[]dist,int mid,double hour){
        double time = 0.0;
        for(int ele : dist){
           time =  Math.ceil(time);
        //    System.out.println(time);
            time += (((double)ele)/(double)mid);
        }
        // System.out.println("time "+time);
        return time <= hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
      int low = 1 , high = 10000000 , max = high; 
      while(low <= high){
        int mid = low+(high-low)/2;
        if(isPossible(dist,mid,hour)){
            high = mid-1;
            // System.out.println("Possible "+mid);
        }
        else {
            low = mid+1;
            // System.out.println("Not Possible "+mid);
            }
      }
      return low == max+1 ? -1 : low;
    }
}