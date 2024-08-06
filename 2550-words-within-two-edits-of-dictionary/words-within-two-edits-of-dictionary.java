class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new LinkedList<>();
        for(int i=0;i<queries.length;i++){
            String str1 = queries[i];
            for(int j = 0;j<dictionary.length;j++){
                String str2 = dictionary[j];
                int count = 0;
                for(int k=0;k<str1.length();k++){
                    if(str1.charAt(k) != str2.charAt(k)) count++;
                }
                if(count <= 2) {
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }
}