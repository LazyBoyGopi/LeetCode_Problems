class Solution {
    private class Pair{
        int value;
        int index;
        public Pair(int value_,int index_){
            value = value_;
            index = index_;
        }
    }
    public static void swap(int[]ar,int i,int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public int getNewNum(int[]ar){
        int newNum = 0;
        for(int ele : ar){
            newNum = newNum*10+ele;
        }
        return newNum;
    }
    public int maximumSwap(int num) {
        // Queue<Pair>queue = new PriorityQueue<>((a,b)-> {
        //     if(a.value != b.value){
        //         return Integer.compare(b.value,a.value);
        //     }else{
        //         return Integer.compare(a.index,b.index);
        //     }
        // });
        // int curIdx = (int)Math.log10(num);
        // int[]ar = new int[curIdx+1];
        // while(num > 0){
        //     ar[curIdx] = num%10;
        //     queue.offer(new Pair(num%10,curIdx--));
        //     num /= 10;
        // }
        // curIdx = 0;
        // int swapIdx = -1;
        // for(Pair p : queue){
        //     System.out.println(p.value +" "+p.index);
        // }
        // while(!queue.isEmpty()){
        //     Pair curPair = queue.poll();
        //     if(curPair.index != curIdx){
        //         swapIdx = curPair.index;
        //         break;
        //     }
        //     curIdx++;
        // }
        // if(swapIdx != -1){
        //     int temp = ar[swapIdx];
        //     ar[swapIdx] = ar[curIdx];
        //     ar[curIdx] = temp;
        // }
        // int ans = 0;
        // for(int ch : ar){
        //     ans = ans*10+ch;
        // }
        // return ans;

        int maxNum = num;
        int len = (int)Math.log10(num);
        int[]ar = new int[len+1];
        for(int i=len;i>=0;i--){
            ar[i] = num%10;
            num /= 10;
        }
        for(int i=0;i<ar.length;i++){
            for(int j=i+1;j<ar.length;j++){
                swap(ar,i,j);
                maxNum  = Math.max(maxNum,getNewNum(ar));
                swap(ar,i,j);
            }
        }
        return maxNum;
    }
}