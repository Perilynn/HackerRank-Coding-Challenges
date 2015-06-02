class Grid(object):
    def __init__(self, rows, m, n):
        self.rows = rows
        self.m = m
        self.n = n
    def largestConnectedComponent(self):
        self.unexplored = []
        for i in xrange(self.m):
            self.unexplored.append([])
            for j in xrange(self.n):
                self.unexplored[i].append(bool(self.rows[i][j]))
        maxConn = 0
        for i in xrange(self.m):
            for j in xrange(self.n):
                if self.unexplored[i][j]:
                    maxConn = max(maxConn, self.lccHelper(i, j))
        return maxConn
    def lccHelper(self, i, j):
        if i < 0 or j < 0 or i >= self.m or j >= self.n:
            return 0
        if not self.unexplored[i][j]:
            return 0
        self.unexplored[i][j] = 0
        return 1 + self.lccHelper(i-1, j-1) + self.lccHelper(i-1, j) + self.lccHelper(i-1, j+1) + \
                   self.lccHelper(i, j-1) + self.lccHelper(i, j+1) + \
                   self.lccHelper(i+1, j-1) + self.lccHelper(i+1, j) + self.lccHelper(i+1, j+1)

def getInput():
    numRows = input()
    numCols = input()
    rows = []
    for m in xrange(numRows):
        row = [bool(int(num)) for num in raw_input().split(" ")]
        rows.append(row)
    return Grid(rows, numRows, numCols)

if __name__ == "__main__":
    grid = getInput()
    print grid.largestConnectedComponent()
