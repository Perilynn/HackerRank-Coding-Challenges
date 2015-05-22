input()
while 1:
 a=input();b=[0,0];c=1
 for i in range(10):b[i%2]+=(-1)**(i/2)*a**i/c;c*=i+1
 print b[1],b[0]
# score: 14.50