#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int power(int base, int exp) {
    int tot = 1;
    for (int i = 0; i < exp; i++) {
        tot = tot * base % 100000;
    }
    return tot;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int cases;
    cin >> cases;
    int x[cases];
    for (int i = 0; i < cases; i++) {
        cin >> x[i];
    }
    for (int i = 0; i < cases; i++) {
        cout << (power(2, x[i]) - 1) << "\n";
    }
    return 0;
}