class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[]copyArr = new int[len];
        for(int i=0;i<len;i++){
            copyArr[i] = arr[i];
        }
        Set<Integer>set = new HashSet();
        for(int i=0;i<len;i++){
            set.add(arr[i]);
        }
        arr = new int[set.size()];
        int idx = 0;
        for(int ele : set){
            arr[idx++] = ele;
        }
        Arrays.sort(arr);
        Map<Integer,Integer>map = new HashMap();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],i+1);
        }
        for(int i=0;i<len;i++){
            copyArr[i] = map.get(copyArr[i]);
        }
        return copyArr;
    }
}