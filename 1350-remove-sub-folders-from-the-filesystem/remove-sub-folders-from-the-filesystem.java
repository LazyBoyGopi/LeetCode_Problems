class Solution {
    public List<String> removeSubfolders(String[] folder) {

        Arrays.sort(folder);
        List<String>list = new ArrayList();
        int len = folder.length;

        String lastStr = folder[0];
        for(int i=1;i<len;i++){
            String curStr = folder[i];
            if(curStr.startsWith(lastStr) &&  curStr.charAt(lastStr.length()) == '/') {
                continue;
            }
            list.add(lastStr);
            lastStr = curStr;
        }
        if(list.size() == 0 || !list.get(list.size()-1).equals(lastStr)) list.add(lastStr);
        return list;
    }
}