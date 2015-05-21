#include <iostream>
using namespace std;

int main() {
    int numcases;
    cin >> numcases;

    int temp;
    for (int i = 0; i < numcases; i++) {
        cin >> temp;
        int res = 1;
        for (int j = 0; j < temp; j++) {
            res *= 2;
            if (j == temp - 1) {
                res -= 1;
            }
            res %= 100000;
        }
        cout << res << endl;
    }
    return 0;
}
