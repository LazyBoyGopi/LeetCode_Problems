class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        List<Integer> list = new LinkedList<>();
        list.add(deck[deck.length-1]);
        for(int i=deck.length-2;i>=0;i--)
        {
            list.add(0,list.remove(list.size()-1));
            list.add(0,deck[i]);
        }
        for(int i=0;i<deck.length;i++)
        {
            deck[i] = list.get(i);
        }
        return deck;
    }
}