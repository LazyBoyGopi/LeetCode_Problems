class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[] prefixXOR = new int[n + 1];
        
        // Compute the prefix XOR array
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        
        // Iterate through all possible pairs (i, k)
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefixXOR[i] == prefixXOR[k + 1]) {
                    count += (k - i);
                }
            }
        }
        
        return count;
    }
}