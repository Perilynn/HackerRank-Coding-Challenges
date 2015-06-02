## Solution for HackerRank Algorithms/Search/Connected Cell In A Grid
## https://www.hackerrank.com/challenges/connected-cell-in-a-grid
__author__ = 'modi95'
__date__ = 'Monday 1 June 2015'

from sys import stdin

rows = 0
cols = 0
matrix = []
curr = '2'

set_sizes = {}

def merge_around(y, x):

    ##3
    if (x != cols-1):
        if (matrix[y][x+1] == '1'):
            matrix[y][x+1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y, x+1)

    ##4:30
    if ((x != cols-1) and (y != rows-1)):
        if (matrix[y+1][x+1] == '1'):
            matrix[y+1][x+1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y+1, x+1)


    ##6
    if (y != rows-1):
        if (matrix[y+1][x] == '1'):
            matrix[y+1][x] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y+1, x)

    ##7:30
    if ((y != rows-1) and (x != 0)):
        if (matrix[y+1][x-1] == '1'):
            matrix[y+1][x-1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y+1, x-1)

    ##9
    if (x != 0):
        if (matrix[y][x-1] == '1'):
            matrix[y][x-1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y, x-1)

    ##10:30
    if ((x != 0) and (y != 0)):
        if (matrix[y-1][x-1] == '1'):
            matrix[y-1][x-1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y-1, x-1)
    
    ##12
    if (y != 0):
        if (matrix[y-1][x] == '1'):
            matrix[y-1][x] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y-1, x)

    ##1:30
    if ((y != 0) and (x != cols-1)):
        if (matrix[y-1][x+1] == '1'):
            matrix[y-1][x+1] = matrix[y][x]
            set_sizes[matrix[y][x]] += 1
            merge_around(y-1, x+1)

    return



def output_soln():
    #for row in matrix:
        #print row

    max = 0 
    for set in set_sizes:
        max = set_sizes[set] if (set_sizes[set] > max) else max

    print max
    return

#returns list of lines containing orders
def get_inputs():
    global rows
    global cols
    global matrix

    line1 = stdin.readline()
    rows = int(line1)

    line2 = stdin.readline()
    cols = int(line2)

    for i in range (0, rows):
        line = stdin.readline()
        line = line.replace(' ', '')
        line = line.replace('\n', '')
        matrix.append(list(line))

    return


def main():
    get_inputs()
    global curr
    
    for y in range(0, rows):
        for x in range (0, cols):
            if (matrix[y][x] == '1'):
                matrix[y][x] = curr
                set_sizes[curr] = 1
                curr = chr(ord(curr) + 1)
                merge_around(y, x)

    output_soln()

    return

if __name__ == "__main__":
    main()
