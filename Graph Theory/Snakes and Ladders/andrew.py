class VisitTracker(object):
    def __init__(self, n):
        self.n = n
        self.l = [False,]*n
    def visited(self, i):
        if i <= 0 or i > self.n:
            raise ValueError("i is out-of-bounds")
        return self.l[i-1]
    def setVisited(self, i):
        if i <= 0 or i > self.n:
            raise ValueError("i is out-of-bounds")
        self.l[i-1] = True

class Board(object):
    def __init__(self, ladders, snakes, maxNum=100):
        self.jumps = {}
        # validate ladders
        for a,b in ladders:
            if a >= b:
                raise ValueError("Ladders must move up")
            if a in self.jumps:
                raise ValueError("Redefinition of a jump")
            if b in self.jumps:
                raise ValueError("Cannot chain jumps")
            self.jumps[a] = b
        # validate snakes
        for a,b in snakes:
            if a <= b:
                raise ValueError("Snakes must move down")
            if a in self.jumps:
                raise ValueError("Redefinition of a jump")
            if b in self.jumps:
                raise ValueError("Cannot chain jumps")
            self.jumps[a] = b
        self.maxNum = 100
    def nextNums(self, currNum):
        nextNs = [currNum+die for die in xrange(1,7)]
        for idx, num in enumerate(nextNs[:]):
            if num > self.maxNum: # prevent overflow
                nextNs[idx] = currNum
            elif num in self.jumps: # ladders or snakes
                nextNs[idx] = self.jumps[num]
        return nextNs
    def solve(self):
        q = [(1,0),]
        v = VisitTracker(self.maxNum)
        while len(q) > 0:
            currNum, depth = q.pop(0)
            if currNum == self.maxNum:
                return depth
            elif not v.visited(currNum):
                v.setVisited(currNum)
                for num in self.nextNums(currNum):
                    q.append((num, depth+1))
        return -1
            

def getInputs():
    numTestcases = input()
    testcases = []
    for t in xrange(numTestcases):
        ladders = []
        for n in xrange(input()):
            ladders.append([int(i) for i in raw_input().split(" ")])
        snakes = []
        for m in xrange(input()):
            snakes.append([int(i) for i in raw_input().split(" ")])
        testcases.append(Board(ladders, snakes))
    return testcases

if __name__ == "__main__":
    testcases = getInputs()
    for testcase in testcases:
        print testcase.solve()