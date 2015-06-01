# Fun Problem 5
def toInt(s):
    d = {'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}
    ret = 0
    for char in s:
        ret = ret * 10 + d[char]
    return ret

def toString(i):
    if i == 0:
        return 0
    d = {0:'0',1:'1',2:'2',3:'3',4:'4',5:'5',6:'6',7:'7',8:'8',9:'9'}
    ret = ""
    while i > 0:
        ret = d[i % 10] + ret
        i /= 10
    return ret

# Fun Problem 6
from string import digits

def isNumber(s):
    encounteredDecimal = False
    for idx, char in enumerate(s):
        if char == '-':
            if idx != 0:
                return False
        elif char == '.':
            if encounteredDecimal:
                return False
            else:
                encounteredDecimal = True
        else:
            if char not in digits:
                return False
    return True
