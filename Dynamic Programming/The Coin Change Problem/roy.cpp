#include <vector>
#include <iostream>
using namespace std;

long waystosum(int sum, vector<int> coins) {
    vector<long> memo(sum + 1);
    memo[0] = 1;
    for (auto &coin : coins) {
        for (int i = coin; i <= sum; i++) {
            memo[i] += memo[i-coin];
        }
    }
    return memo[sum];
}

int main() {
    int sum, numcoins;
    vector<int> coins;
    cin >> sum >> numcoins;
    int tempcoin;
    for (int i = 0; i < numcoins; i++) {
        cin >> tempcoin;
        coins.push_back(tempcoin);
    }

    cout << waystosum(sum, coins) << endl;
    return 0;
}
