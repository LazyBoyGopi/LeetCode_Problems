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
    private boolean isValid(Transaction t,List<Transaction>list){
        if(t.amount > 1000){
            return false;
        }
        for(Transaction l : list){
             if(Math.abs(t.time -l.time)<=60 && !(t.city.equals(l.city)))
                return false;
        }
        return true;
    }
}