# Enter your code here. Read input from STDIN. Print output to STDOUT

import itertools

numBulbs = int(input())
bulbs = []

for i in range(numBulbs):
    bulb = int(input())
    bulbs.append(bulb)
    print (len(list(itertools.permutations(bulbs, numBulbs))) + 1)