class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        boolean freq[] = new boolean[1001];
        Arrays.sort(arr);
        int count = 1;
        int last = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] == last ) count++;
            else {
                if(freq[count]) return false;
                else freq[count] = true;
                last = arr[i];
                count = 1;
            }
        }
        return !freq[count];
    }
}