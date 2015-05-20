#!/bin/python

def opDeterminer(ops):
    vals = []
    for op in ops:
        if op[0] == 'r':
            (vals, success) = removeOp(vals, long(op[1]))
            if not success:
                print ('Wrong!')
                continue
        elif op[0] == 'a':
            (vals, success) = addOp(vals, long(op[1]))
        
        median(vals)

def removeOp(vals, toRemove):
    if toRemove in vals:
        vals.remove(toRemove)
        return (vals, True)
    else:
        return (vals, False)

def addOp(vals, toAdd):
    newVals = []
    success = False
    
    for val in vals:
        if val <= toAdd or success:
            newVals.append(val)
        else:
            newVals.append(toAdd)
            newVals.append(val)
            success = True
    
    if not success:
        newVals.append(toAdd)
    return (newVals, success)

def median(vals):
    size = len(vals)
    if size:
        median = 0.5 * (vals[size/2] + vals[(size-1)/2])
    else:
        median = None
        
    if not median:
        print ('Wrong!')
    elif median.is_integer():
        print (int(median))
    else:
        print (median)

numOps = int(input())
ops = []
for i in range(numOps):
    op = raw_input().strip().split(' ')
    ops.append(op)
    
opDeterminer(ops)