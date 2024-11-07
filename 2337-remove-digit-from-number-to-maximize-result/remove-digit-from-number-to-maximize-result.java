class Solution {
    public String removeDigit(String number, char digit) {
        List<Integer>indexes = new LinkedList();
        for(int i=0;i<number.length();i++){
            if(number.charAt(i) == digit){
                indexes.add(i);
            }
        }
        List<String>list = new LinkedList();
        for(int ele : indexes){
            list.add(new StringBuilder(number).deleteCharAt(ele).toString());
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}