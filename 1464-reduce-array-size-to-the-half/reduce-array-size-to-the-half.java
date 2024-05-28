import java.util.*;
class Solution {
    public int minSetSize(int[] arr) {
        int[]freq = new int[100001];
        for(int ele : arr){
            freq[ele]++;
        }
        Arrays.sort(freq);
        int len = arr.length/2 , count =0 ,i;
        for(i=freq.length-1;i>=0; i--){
            if(count >= len) return freq.length-1-i; 
            count += freq[i];
        }
        return freq.length-1-i; 
    //     int len = arr.length;
    //    Map<Integer,Integer> freqMap = new HashMap<>();
    //    for(int ele : arr){
    //     freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);
    //    } 
    //    Collection<Integer> v = freqMap.values();
    //     List<Integer> values = new LinkedList<>(v);
    //     int count = 0 ,i;
    //    Collections.sort(values);
    //    for(i=values.size()-1;i>=0;i--){
    //     if(count >= len/2) return values.size()-i-1;
    //     count += values.get(i);
    //    }
    //    return values.size()-i-1;
    }
}