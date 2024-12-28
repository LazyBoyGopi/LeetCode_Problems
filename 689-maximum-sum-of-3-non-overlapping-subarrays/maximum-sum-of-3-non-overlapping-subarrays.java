/*class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        Queue<long[]>queue = new PriorityQueue<long[]>((a,b) -> {
            if(a[0] == b[0]) Long.compare(a[1],b[1]);
            return Long.compare(b[0],a[0]);
        });
        long sum = 0l;
        int len = nums.length;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        queue.offer(new long[]{sum,0});
        for(int i=k;i<len;i++){
            sum -= nums[i-k];
            sum += nums[i];
            queue.offer(new long[]{sum,i-k+1});
        }
        for(long[]ar : queue){
            System.out.println(Arrays.toString(ar));
        }
        int[]ans = new int[3];
        int j=0;
        Set<Integer>set = new HashSet();
        outer : while(!queue.isEmpty()){
            long[]top = queue.poll();
            int topIdx = (int)top[1];
            for(int i=topIdx;i<topIdx+k;i++){
                if(set.contains(i)) continue outer;
            }
            for(int i=topIdx;i<topIdx+k;i++){
                set.add(i);
            }
            ans[j++] = topIdx;
            if(j == 3) break;
        }
        Arrays.sort(ans);
        return ans;
    }
} */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] ar = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] ans = Solution.maxSumOfThreeSubarrays(ar, k);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Arrays to store the best indices for one and two subarrays
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Track the best sum and index for the left subarray
        int maxSum = 0;
        for (int i = k - 1; i < n; i++) {
            int currentSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        
        // Track the best sum and index for the right subarray
        maxSum = 0;
        for (int i = n - k; i >= 0; i--) {
            int currentSum = prefixSum[i + k] - prefixSum[i];
            if (currentSum >= maxSum) {
                maxSum = currentSum;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        
        // Find the maximum sum of three subarrays
        int[] result = new int[3];
        maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int leftIdx = left[i - 1];
            int rightIdx = right[i + k];
            int currentSum = (prefixSum[i + k] - prefixSum[i]) +
                             (prefixSum[leftIdx + k] - prefixSum[leftIdx]) +
                             (prefixSum[rightIdx + k] - prefixSum[rightIdx]);
                             
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = leftIdx;
                result[1] = i;
                result[2] = rightIdx;
            }
        }
        
        return result;
    }
}
