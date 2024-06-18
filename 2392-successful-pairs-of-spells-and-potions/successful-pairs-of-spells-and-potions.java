class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        Map<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<spells.length;i++){
           if(map.containsKey(spells[i])){
                map.get(spells[i]).add(i);
            }
            else
            map.put(spells[i],new LinkedList<>(Arrays.asList(i)));
        }
        Arrays.sort(spells);
        int[]pairs = new int[spells.length];
        int lastIdx = -1 , len = potions.length;
        for(int i=0;i<spells.length;i++){
            for(int j=lastIdx == -1 ? potions.length-1 : lastIdx;j>=0;j--){
                if((long)potions[j]*spells[i] >= success) {
                    lastIdx = j;
                }
                else break;
            }
            pairs[map.get(spells[i]).get(0)] = lastIdx == -1 ? 0 : len - lastIdx;
            map.get(spells[i]).remove(0);
        }
        return pairs;
    }
}