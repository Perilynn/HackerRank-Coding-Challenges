#xrange because we don't need an actual list
#Code possible because Python automatically accounts for overflow
for x in xrange(input()):
    print ((2**input())-1) % 10**5