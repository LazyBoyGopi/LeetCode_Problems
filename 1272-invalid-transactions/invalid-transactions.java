class Solution {
    static class Transaction{
        String name;
        int amount;
        int time;
        String city;

        public String toString(){
            return name +","+time+","+amount+","+city;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        Transaction[]trans = new Transaction[transactions.length];
        List<String> output = new ArrayList();
        for(int i=0;i<transactions.length;i++){
            String[]data = transactions[i].split(",");
            trans[i] = new Transaction();
            trans[i].name = data[0];
            trans[i].time = Integer.parseInt(data[1]);
            trans[i].amount = Integer.parseInt(data[2]);
            trans[i].city = data[3];
        }
        for(int i=0;i<trans.length;i++){
            for(int j=0;j<trans.length;j++){
                if(i == j) continue;
                if(trans[i].name.equals(trans[j].name) &&
                    !trans[i].city.equals(trans[j].city) && Math.abs(trans[i].time - trans[j].time) <= 60){
                        output.add(trans[i].toString());
                        break;
                }else if(trans[i].amount >= 1000){
                    output.add(trans[i].toString());
                    break;
                }
            }
        }
        return output;
    }
}