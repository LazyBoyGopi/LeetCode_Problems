class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>less = new ArrayList(), greater = new ArrayList(), piv = new ArrayList();
        for(int ele : nums){
            if(ele == pivot){
                piv.add(ele);
            }else if(ele > pivot){
                greater.add(ele);
            }else{
                less.add(ele);
            }
        }
        int i=0;
        append(nums,i,less);
        i+=less.size();
        append(nums,i,piv);
        i+=piv.size();
        append(nums,i,greater);
        return nums;

    }
    public static void append(int[]nums,int j,List<Integer>list){
        int len = list.size();
        for(int i=0;i<len;i++){
            nums[j++] = list.get(i);
        }
    }
}