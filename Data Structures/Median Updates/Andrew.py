#!/bin/python

def median(s,x):
        if(command == 'r' and len(list) == 0):
            print "Wrong!"
        elif(command == 'r'):
            list.remove(x)
            printMedian()
        elif(command == 'a'):
            list.append(x)
            list.sort()
            printMedian()

def printMedian():
    if len(list) == 0:
        print "Wrong!"
    elif (len(list) %2 == 0):
         print '%.17g' % float(((list[(len(list)/2)-1]) + (list[(len(list)/2)])) /2.0)   
    else:
         print '%.17g' % float(list[int(len(list)/2.0)])
       
        
    
            
N = input()
list = []
for i in range(0, N):
    tmp = raw_input().strip().split(' ')
    command = tmp[0]
    element = int(tmp[1])
    median(command,element)
