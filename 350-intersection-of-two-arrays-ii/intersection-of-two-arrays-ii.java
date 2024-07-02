class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        List<Integer>list = new LinkedList<>();
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                int count = map.get(nums2[i]);
                if(count > 1)
                    map.put(nums2[i],count-1);
                else 
                    map.remove(nums2[i]);

                list.add(nums2[i]);
            }
        }
        int[]ar = new int[list.size()];
        for(int i=0;i<ar.length;i++){
            ar[i] = list.get(i);
        }
        return ar;
    }
}