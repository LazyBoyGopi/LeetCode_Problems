class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[]ar = sentence.split(" ");
        for(String str : dictionary){
            for(int i=0;i<ar.length;i++){
                if(ar[i].startsWith(str)){
                    ar[i] = str;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : ar) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
        /*Map<String,String>map = new HashMap<>();
        for(String str : dictionary){
            int idx = sentence.indexOf(str);
            if(idx != -1){
                int endIdx = sentence.indexOf(' ',idx);
                endIdx = endIdx == -1 ? sentence.length() : endIdx;
                map.put(sentence.substring(idx,endIdx),str);
            }
        }
        String[]ar = sentence.split(" ");
        for(int i=0;i<ar.length;i++){
            String str = ar[i];
            if(map.containsKey(str)){
                ar[i] = map.get(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : ar){
            sb.append(str);
            sb.append(" ");
        }
        System.out.println(map);
        return sb.deleteCharAt(sb.length()-1).toString();*/
    }
}