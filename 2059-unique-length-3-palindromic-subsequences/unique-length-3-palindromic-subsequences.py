class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        map = {}
        set = {0}
        count = 0
        for i in range(len(s)):
            curCh = s[i]
            if not curCh in map:
                map[curCh] = i
        for i in range(len(s)-1,0,-1):
            curCh  = s[i]
            firstIdx = map[curCh]
            
            if firstIdx < i and not curCh in set:
                print(curCh,firstIdx)
                uniqueCharacters = {0}
                uniqueCharacters.remove(0)
                for j in range(firstIdx+1,i):
                    uniqueCharacters.add(s[j])
                print(curCh,uniqueCharacters)
                count += len(uniqueCharacters)
                set.add(curCh)
        return count
        