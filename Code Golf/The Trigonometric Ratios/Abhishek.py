#SCORE 12.80
from math import *
input()
while 1:
    a=input(); b=[0,0]; 
    for j in range(10):b[j%2]+= (-1)**(j/2)*(a**j/factorial(j))
    print b[1],b[0]
