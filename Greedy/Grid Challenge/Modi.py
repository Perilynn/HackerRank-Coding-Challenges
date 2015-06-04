## Solution for HackerRank Algorithms/Greedy/Grid Challenge
## https://www.hackerrank.com/challenges/grid-challenge
__author__ = 'modi95'
__date__ = 'Thursday 4 June 2015'

from sys import stdin


def output_soln():
    max = 0 
    for set in set_sizes:
        max = set_sizes[set] if (set_sizes[set] > max) else max

    print max
    return

#returns list of lines containing orders
def get_inputs():

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
