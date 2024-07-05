class Pair{
    int data;
    char ch;

    public Pair(int data,char ch){
        this.data = data;
        this.ch = ch;
    }
}

class Solution {
    public String frequencySort(String s) {
        int[]ar = new int[128];
        for(int i=0;i<s.length();i++){
            ar[s.charAt(i)]++;
        }
        Queue<Pair> q = new PriorityQueue<>((a,b) -> b.data-a.data);
        for(int i=0;i<128;i++){
            if(ar[i] != 0)
            q.offer(new Pair(ar[i],(char)i));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Pair p = q.poll();
            int times = p.data;
            char ch = p.ch;
            for(int i=0;i<times;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}