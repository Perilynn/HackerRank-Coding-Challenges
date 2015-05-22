input()
def z(x,n):return 1 if n==0 else x/n*z(x,n-1)
while 1:
    a=[0,0];q=input()
    for i in range(10):a[i%2]+=(-1)**(i/2)*z(q,i)
    print a[1],a[0]