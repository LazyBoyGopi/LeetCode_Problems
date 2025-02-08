import java.util.*;
import java.util.Collections;

class NumberContainers {

    Map<Integer,Integer>numbersAtIndexes;
    Map<Integer,PriorityQueue<Integer>> indexesOfNumbers;

    public NumberContainers() {
        numbersAtIndexes = new HashMap();
        indexesOfNumbers = new HashMap();
    }
    
    public void change(int index, int number) {
        if(numbersAtIndexes.containsKey(index)){
            int ele = numbersAtIndexes.get(index);
            if(ele == number){
                return;
            }
            indexesOfNumbers.get(ele).remove(index);
        }
        indexesOfNumbers.computeIfAbsent(number,k->new PriorityQueue<Integer>()).offer(index);
        numbersAtIndexes.put(index,number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq = indexesOfNumbers.getOrDefault(number,new PriorityQueue<Integer>());
        return pq.size() == 0 ? -1 : pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */