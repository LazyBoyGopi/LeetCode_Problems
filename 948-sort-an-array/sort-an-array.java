class Solution {
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int conquer(int[]nums,int st,int end){
        int pivotIdx = st;
        int low = pivotIdx+1 , high = end;
        while(low <= high){
            while(low <= high && nums[low] <= nums[pivotIdx]) low++;
            while(low <= high && nums[high] > nums[pivotIdx]) high--;
            if(low <= high) swap(nums,low,high);
        }
        swap(nums,high,pivotIdx);
        return high;
    }
    private void helperQuickSort(int[]nums,int st,int end){
        if(st >= end) return;
        int pivot = conquer(nums,st,end);
        helperQuickSort(nums,st,pivot-1);
        helperQuickSort(nums,pivot+1,end);
    }

    private void conquer(int[]nums,int st,int mid,int end){
        int[]ar = new int[end-st+1];
        int idx1 = st , idx2 = mid+1 , idx = 0;
        while(idx1 <= mid && idx2 <= end){
            if(nums[idx1] <= nums[idx2]) ar[idx++] = nums[idx1++];
            else ar[idx++] = nums[idx2++];
        }
        while(idx1 <= mid) ar[idx++] = nums[idx1++];
        while(idx2 <= end) ar[idx++] = nums[idx2++];

        for(int i=0,j=st;i<ar.length;i++,j++) nums[j] = ar[i];
    }
    private void mergeSort(int[]nums,int st,int end){
        if(st >= end) return;
        int mid = st+(end-st)/2;
        mergeSort(nums,st,mid);
        mergeSort(nums,mid+1,end);
        conquer(nums,st,mid,end);
    }

    public int[] sortArray(int[] nums) {
        // helperQuickSort(nums,0,nums.length-1);
        // mergeSort(nums,0,nums.length-1);
        Queue<Integer> q = new PriorityQueue();
        for(int ele : nums) q.add(ele);
        int idx = 0;
        while(!q.isEmpty()){
            nums[idx++] = q.poll();
        }
        return nums;
    }
}