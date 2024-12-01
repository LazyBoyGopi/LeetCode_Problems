class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet();
        for (int ele : arr) {
            if (s.contains(ele * 2) || (ele % 2 == 0 && s.contains(ele / 2)))
                return true;
            s.add(ele);
        }
        return false;
    }
}