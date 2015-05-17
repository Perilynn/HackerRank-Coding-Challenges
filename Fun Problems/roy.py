#logarithmic exponentiation
def exp(x, y):
    ret = 1
    while y != 0:
        if y % 2 == 1:
            ret = ret * x
        x = x * x
        y = y / 2
    return ret
