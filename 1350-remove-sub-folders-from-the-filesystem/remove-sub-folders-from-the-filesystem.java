class Solution {
    private boolean doesContains(List<String>list,String str){
        for(String curStr : list){
            if(str.startsWith(curStr) && str.charAt(curStr.length()) == '/') return true;
        }
        return false;
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String>list = new ArrayList();
        for(String str : folder){
            if(!doesContains(list,str)) list.add(str);
        }
        return list;
    }
}