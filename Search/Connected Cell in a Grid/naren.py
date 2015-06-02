R = int(raw_input())
C = int(raw_input())

grid = []

for i in xrange(R):
    grid.append(map(int, raw_input().split()))

def floodFill(r, c):
    if r < 0 or r >= R or c < 0 or c >= C:
        return 0
    elif grid[r][c] == 1:
        grid[r][c] = 0
        return 1 + floodFill(r-1, c) + floodFill(r+1, c) + floodFill(r, c-1) + floodFill(r, c+1) \
            + floodFill(r-1, c-1) + floodFill(r-1, c+1) + floodFill(r+1, c-1) + floodFill(r+1, c+1)
    return 0

count = 0
    
for r in xrange(R):
    for c in xrange(C):
        count = max(count, floodFill(r, c))

print count
