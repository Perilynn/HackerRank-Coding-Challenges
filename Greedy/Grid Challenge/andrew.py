class Grid(object):
    def __init__(self, rows):
        self.rows = rows
    def canBeSorted(self):
        temp = []
        for row in self.rows:
            temp.append("".join(sorted(row)))
        # check columns
        for j in xrange(len(temp[0])):
            col = [temp[i][j] for i in xrange(len(self.rows))]
            if col != sorted(col):
                return False
        return True

def getInput():
    numTests = input()
    testcases = []
    for t in xrange(numTests):
        numRows = input()
        rows = []
        for row in xrange(numRows):
            rows.append(raw_input())
        testcases.append(Grid(rows))
    return testcases

if __name__ == "__main__":
    testcases = getInput()
    for testcase in testcases:
        if testcase.canBeSorted():
            print "YES"
        else:
            print "NO"
