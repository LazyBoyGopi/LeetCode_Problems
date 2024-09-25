class MapSum {
    Map<String,Integer>map;
    public MapSum() {
        map = new HashMap();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum = 0, len = prefix.length();
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            String key = entry.getKey();
            if(key.length()>=len && key.substring(0,len).equals(prefix)) sum += entry.getValue();
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */