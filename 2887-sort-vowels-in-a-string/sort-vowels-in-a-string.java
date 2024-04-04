class Solution {
    public String sortVowels(String s) {
        int[]ar = new int[10];
        for(char ch : s.toCharArray())
        {
            switch(ch)
            {
                case 'A' -> ar[0]++;
                case 'E' -> ar[1]++;
                case 'I' -> ar[2]++;
                case 'O' -> ar[3]++;
                case 'U' -> ar[4]++;
                case 'a' -> ar[5]++;
                case 'e' -> ar[6]++;
                case 'i' -> ar[7]++;
                case 'o' -> ar[8]++;
                case 'u' -> ar[9]++;
            }
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            switch(ch)
            {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': char curChar = ' ';
                for(int i = 0;i<ar.length;i++)
                {
                    if(ar[i] > 0)
                    {
                        switch(i)
                        {
                            case 0 -> curChar = 'A';
                            case 1 -> curChar = 'E';
                            case 2 -> curChar = 'I';
                            case 3 -> curChar = 'O';
                            case 4 -> curChar = 'U';
                            case 5 -> curChar = 'a';
                            case 6 -> curChar = 'e';
                            case 7 -> curChar = 'i';
                            case 8 -> curChar = 'o';
                            case 9 -> curChar = 'u';
                        }
                        ar[i]--;
                        break;
                    }
                }
                sb.append(curChar);
                break;
                default : sb.append(ch);
            }
        }
        return sb.toString();
    }
}