class Solution {
    static class Transaction{
        String name;
        int time;
        int amount;
        String city;
        String orginal;

        Transaction(String transaction){
            orginal = transaction;
            String[]split = transaction.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        Map<String,List<Transaction>>map = new HashMap();
        List<Transaction> allTransactions = new ArrayList();
        List<String>output = new ArrayList();

        for(String t : transactions){
            Transaction trans = new Transaction(t);
            allTransactions.add(trans);
            map.putIfAbsent(trans.name,new ArrayList());
            map.get(trans.name).add(trans);
        }
        for(Transaction trans : allTransactions){
            if(!isValid(trans,map.get(trans.name))){
                output.add(trans.orginal);
            }
        }
        return output;
    }
    private boolean isValid(Transaction trans,List<Transaction>list){
        if(trans.amount > 1000){
            return false;
        }
        for(Transaction l : list){
            if(!l.city.equals(trans.city) && Math.abs(l.time-trans.time) <= 60) return false;
        }
        return true;
    }
}