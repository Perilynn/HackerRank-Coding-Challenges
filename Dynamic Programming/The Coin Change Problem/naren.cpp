#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void getParams(int& n, int& m);
int getChange(int n, int m, vector<int> coins);

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n,m;
    getParams(n,m);
    if(m <= 0){
        cout<<0<<endl;
        return 0;
    }
    vector<int> coins;
    for(int i; i < m; i++){
        int x;
        cin>>x;
        coins.push_back(x);
    }
    int combos = getChange(n, m, coins);
    cout<< combos <<endl;
    return 0;
}

void getParams(int& n, int& m){
    cin >> n;
    cin >> m;
}

int getChange(int n, int m, vector<int> coins){
     vector<int> combos(n + 1);
     combos[0] = 1;
     for(int i = 0; i < coins.size(); i++) {
        for(int j = coins[i]; j <= n; j++) {
            combos[j] += combos[j - coins[i]];
        }
     }
     return combos[n];
}
