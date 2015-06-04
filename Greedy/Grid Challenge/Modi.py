## Solution for HackerRank Algorithms/Greedy/Grid Challenge
## https://www.hackerrank.com/challenges/grid-challenge

__author__ = 'modi95'
__date__ = 'Thursday 4 June 2015'


# It seems one can rephrase this question as follows:
#
# Can each row be sorted such that:
#   - Each row is in lexicographically sorted
#   - Each column is lexicographically sorted
#
# Trivial Solution Run Time: (sqrt(n)(log n)
#       Sorting each row = (sqrt(n)(log n)
#       Checking columns at the end = n

from sys import stdin

square_size = 0
matrix = []
ith_soln = True



def output_soln():
    global ith_soln
    if ith_soln:
        print("YES")
    else:
        print("NO")
    return

def check_sort_cols():
    global ith_soln
    for i in range(0, square_size):
        curr_char = matrix[0][i]
        for j in range(0, square_size):
            if (curr_char > matrix[j][i]):
                ith_soln = False
                return
            curr_char = matrix[j][i]

def sort_rows():
    for row in matrix:
        row.sort()
        #print row
    return

def get_inputs():
    global square_size
    global matrix
    global ith_soln

    matrix = []
    ith_soln = True

    line_in = stdin.readline()
    square_size = int(line_in)

    for i in range (0, square_size):
        line_in = stdin.readline()
        line_in = line_in.replace('\n', '')
        matrix.append(list(line_in))

    return


def main():

    num_test_cases = int(stdin.readline())

    while (num_test_cases > 0):
        get_inputs()

        sort_rows()
        check_sort_cols()

        output_soln()
        num_test_cases -= 1

    return

if __name__ == "__main__":
    main()
