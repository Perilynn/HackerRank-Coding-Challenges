#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void sumCoins (int amount, vector<int> coins) 
{
    vector<int> memoized(amount + 1);
    vector<int> arr;
    memoized[0] = 1;
    
    for (int i = 0; i < coins.size(); i++)
    {
        int &coinVal = i;
        for (int j = coinVal; j <= amount; j++) 
        {
            memoized[j] += memoized[j - coinVal];
        }
        arr.push_back(coinVal);  
    }
    cout << arr.size() + 1; 
}

int main() {
    int amount; 
    int numCoins;
    vector<int> coins;
    
    cin >> amount >> numCoins;
    
    for (int i = 0; i < numCoins; i++) 
    {
        int temp;
        cin >> temp;
        coins.push_back(temp);
    }
    
    sumCoins (amount, coins);
    return 0;
}