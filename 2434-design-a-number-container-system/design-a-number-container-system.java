import java.util.*;
import java.util.Collections;

class NumberContainers {
    Map<Integer,Integer>numbersAtIndexes;
    Map<Integer,TreeSet<Integer>> indexesOfNumbers;
    public NumberContainers() {
        numbersAtIndexes = new HashMap();
        indexesOfNumbers = new HashMap();
    }
    
    public void change(int index, int number) {
        int curNum = numbersAtIndexes.containsKey(index) ? numbersAtIndexes.get(index) : -1;
        if(curNum != -1){
            indexesOfNumbers.get(curNum).remove(index);
            if(indexesOfNumbers.get(curNum).isEmpty()){
                indexesOfNumbers.remove(curNum);
            }
        }
        numbersAtIndexes.put(index,number);

        // TreeSet ts = new TreeSet(); 
        // Set syncSet = Collections.synchronziedSet(ts);
        indexesOfNumbers.putIfAbsent(number,new TreeSet());
        indexesOfNumbers.get(number).add(index);
    }
    
    public int find(int number) {
        TreeSet<Integer> curQ = indexesOfNumbers.get(number);
        if(curQ == null || curQ.isEmpty()) return -1;
        return curQ.ceiling(-1);
        // return (curQ == null || curQ.isEmpty()) ? -1 : curQ.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */