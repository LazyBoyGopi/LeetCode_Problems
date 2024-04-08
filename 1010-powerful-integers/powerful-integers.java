class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        outer: for (int i = 0;; i++) {
            if(x == 1 && y == 1)
            {
                if(2 <= bound) set.add(2);
                break;
            }
            if (y == 1) {
                int value = (int) Math.pow(x, i) + 1;
                if (value <= bound)
                    set.add(value);
                if (value > bound)
                    break;
                else
                    continue;
            }
            if (x == 1) {
                int value = (int) Math.pow(y, i) + 1;
                if (value <= bound)
                    set.add(value);
                if (value > bound)
                    break;
                else
                    continue;
            }
            inner: for (int j = 0;; j++) {
                int value = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (value <= bound)
                    set.add(value);
                else {
                    break inner;
                }
            }
            if ((int) Math.pow(x, i) > bound)
                break;
        }
        return new LinkedList<Integer>(set);
    }
}