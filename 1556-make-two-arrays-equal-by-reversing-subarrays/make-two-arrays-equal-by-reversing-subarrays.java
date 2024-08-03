import java.util.OptionalInt;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        OptionalInt max1 = Arrays.stream(target).max();
        OptionalInt max2 = Arrays.stream(arr).max();
        int max = Math.max(max1.getAsInt(),max2.getAsInt());
        int[]count = new int[max+1];
        for(int ele : target) count[ele]++;
        for(int ele : arr) count[ele]--;
        for(int ele : count) if(ele != 0) return false;
        return true;
    }
}