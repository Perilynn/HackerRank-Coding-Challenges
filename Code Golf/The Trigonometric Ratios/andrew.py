input()
s=lambda x:x-x**3/6+x**5/120-x**7/5040+x**9/362880
c=lambda x:1-x**2/2+x**4/24-x**6/720+x**8/40320
while 1:x=input();print s(x),c(x)
# Score: 13.00
