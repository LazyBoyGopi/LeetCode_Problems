class Solution(object):
    def countNumberOfDigits(self,num):
        count = 0
        while num > 0:
            num /= 10
            count += 1
        return count
    def isSymmetric(self,num):
        n = self.countNumberOfDigits(num)
        if (n & 1) == 1:
            return False
        n/=2
        org = num
        curCount = 0
        secondSum = 0
        firstSum = 0
        while num > 0:
            last = num%10
            if curCount < n:
                secondSum += last
            else:
                firstSum += last
            curCount += 1
            num /= 10
        return firstSum == secondSum
    def countSymmetricIntegers(self, low, high):
        count = 0
        for i in range(low,high+1):
            if(self.isSymmetric(i)):
                count += 1
        return count
        