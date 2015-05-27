#@Author Andrew Kuznetsov
#@Note Format given by https://code.google.com/p/soc/wiki/PythonStyleGuide.
#@Note Not an optimal solution given access/write runtimes of python lists (as opposed to arrays).

def calculateAmountGivenCoinList(coin_list, amount):
    num_coin_list_length = (amount+1)
    num_coin_list = [0] * (num_coin_list_length) 
    num_coin_list[0] = 1
    for coin in coin_list:
        for current_index in xrange(coin, (num_coin_list_length)):
            num_coin_list[current_index] += num_coin_list[current_index - coin]
    return num_coin_list[amount]

def main():
    amount = int(raw_input().split()[0])
    coin_list = raw_input().split()
    coin_list = [int(i) for i in coin_list]
    print calculateAmountGivenCoinList(coin_list, amount)

main()

