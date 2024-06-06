class Solution {
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int getPivot(int[]nums,int st,int end){
        int pivot = nums[st];
        int low = st+1, high = end;
        while(low <= high){
            while(low <= end && nums[low] <= pivot) low++;
            while(high >= st && nums[high] > pivot) high--;
            if(low < high)
                swap(nums,low,high);
        }
        swap(nums,st,high);
        return high;
    }
    private void sort(int[]nums,int st ,int end){
        if(st >= end) return;
        int pivotIdx = getPivot(nums,st,end);
        sort(nums,st,pivotIdx-1);
        sort(nums,pivotIdx+1,end);
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        sort(hand,0,hand.length-1);
        // if(hand.length  / groupSize  < groupSize) return false;
        int[][]ar = new int[hand.length/groupSize][2];
        for(int[] r : ar) Arrays.fill(r,-1);
        int count = 0;
        for(int ele : hand){
            for(int i=0;i<ar.length;i++){
                if(ar[i][0] == -1){
                    ar[i][0] = ele;
                    if(ar[i][1] == -1) ar[i][1]++;
                    ar[i][1]++;
                    break;
                }
                else if(ar[i][0] != -1 && ar[i][0] == ele-1 && ar[i][1] < groupSize){
                    ar[i][0] = ele;
                    ar[i][1]++;
                    break;
                }
            }
        }
        System.out.println(Arrays.deepToString(ar));
        for(int [] group : ar){
            if(group[1] != groupSize) return false;
            count += groupSize;
            if(groupSize == hand.length) return true;
        }
        if(count != hand.length) return false;
        return true;
    }
}