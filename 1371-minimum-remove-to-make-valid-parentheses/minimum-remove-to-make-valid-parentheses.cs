using System;
using System.Text;

public class Solution {
    public string MinRemoveToMakeValid(string s) {
        StringBuilder str = new StringBuilder();
        int opening = 0, closing = 0;
        for(int i=0;i<s.Length;i++){
            char ch = s[i];
            if(ch == ')'){
                if(opening > 0){
                    opening--;
                    str.Append(ch);
                }else closing++;
            }else if(ch == '('){
                str.Append(ch);
                opening++;
            }else{
                str.Append(ch);
            }
        }
        if(opening > 0){
            for(int i=str.Length-1;i>=0 && opening > 0;i--){
                if(str[i] == '('){
                    opening--;
                    str.Remove(i,1);
                }
            }
        }
        return str.ToString();
    }
}