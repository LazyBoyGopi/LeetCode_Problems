class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer,List<Integer>>map = new HashMap();
        for(int i=0;i<arr.length;i++){
            int bitsCount = Integer.bitCount(arr[i]);
            map.putIfAbsent(bitsCount,new ArrayList());
            map.get(bitsCount).add(arr[i]);
        }
        int idx = 0;
        for(int i=0;i<=32;i++){
            if(map.containsKey(i)){
                List<Integer>list = map.get(i);
                Collections.sort(list);
                for(int ele : list){
                    arr[idx++] = ele;
                }
            }
        }
        return arr;
    }
}