class Solution {
    private int sum(List<Integer>list,int curIdx){
        int sum = 0;
        for(int idx : list) sum += Math.abs(curIdx-idx);
        return sum;
    }
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        List<Integer>[] pre = new LinkedList[len];
        List<Integer>[] suf = new LinkedList[len];

        List<Integer>list = new LinkedList();
        for(int i=0;i<len;i++){
            pre[i] = new LinkedList(list);
            if(boxes.charAt(i) == '1'){
                list.add(i);
            }
        }
        list = new LinkedList();
        for(int i=len-1;i>=0;i--){
            suf[i] = new LinkedList(list);
            if(boxes.charAt(i) == '1'){
                list.add(i);
            }
        }
        int[]pre1 = new int[len];
        int[]suf1 = new int[len];
        for(int i=0;i<len;i++){
            pre1[i] = sum(pre[i],i);
        }
        for(int i=len-1;i>=0;i--){
            suf1[i] = sum(suf[i],i);
        }
        System.out.println(Arrays.toString(pre1)+"\n"+Arrays.toString(suf1));
        int[]ans = new int[len];
        ans[0] = suf1[0];
        ans[len-1] = pre1[len-1];
        for(int i=1;i<len-1;i++){
            ans[i] = pre1[i] + suf1[i];
        }
        return ans;
    }
}