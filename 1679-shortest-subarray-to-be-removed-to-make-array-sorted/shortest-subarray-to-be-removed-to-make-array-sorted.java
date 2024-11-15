class Solution {
    private static boolean isPossible(int mid, int[] arr, boolean[] pre, boolean[] suf) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j = i + mid;
            if (j >= len) {
                if (i == 0 || pre[i-1]) {
                    return true;
                }
            } else {
                int last = i > 0 ? arr[i-1] : 0;
                if (suf[j] && (last <= arr[j])) {
                    return true;
                }
            }
            if(!pre[i]) return false;
        }
        return false;
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        boolean[] suf = new boolean[len];
        boolean[] pre = new boolean[len];

        suf[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            if (suf[i + 1] && arr[i] <= arr[i + 1]) {
                suf[i] = true;
            } else
                break;
        }
        pre[0] = true;
        for (int i = 1; i < len; i++) {
            if (pre[i - 1] && arr[i - 1] <= arr[i]) {
                pre[i] = true;
            } else
                break;
        }
        int st = 0, end = len - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(mid, arr, pre, suf)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return end + 1;
    }
}