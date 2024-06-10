class Solution {
    public List<Integer> findPeaks(int[] mount) {
        ArrayList <Integer> arr1=new ArrayList();
       for(int i=1;i<=mount.length-2;i++)
       {
        if(mount[i-1]<mount[i] && mount[i]>mount[i+1])
        {
            arr1.add(i);
        }
       }
       return arr1; 
    }
}