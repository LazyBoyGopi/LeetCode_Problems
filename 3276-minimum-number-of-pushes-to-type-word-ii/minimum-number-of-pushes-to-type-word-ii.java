import java.util.Collection;
import java.util.Collections;
class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer>map = new HashMap<>();
        for(char ch : word.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int totalCount = 0;
        int setCount = 1 , count = 0;
        List<Integer> values = new LinkedList<>(map.values());
        Collections.sort(values);
        for(int i=values.size()-1;i>=0;i--){
            int value = values.get(i);
            totalCount += (value * setCount);
            count++;
            if(count == 8){
                count = 0;
                setCount++;
            }
        }
        return totalCount;
    }
}