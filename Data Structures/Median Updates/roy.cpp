#include <set>
#include <iomanip>
#include <cmath>
#include <iostream>
using namespace std;

void printmedian(multiset<int> &lesser, multiset<int> &greater) {
    if (greater.size() == 0) {
        cout << "Wrong!" << endl;
        return;
    }

    //even, must do avg
    if (lesser.size() == greater.size()) {
        int bigger = *greater.begin();
        int smaller = *(--lesser.end());
        double med = (double)bigger/2 + (double)smaller/2;
        double whole;
        if (modf(med, &whole) == 0.0) {
            cout << (int) med << endl;
        } else {
        cout << setprecision(1) << fixed << med << endl;
        }
        return;
    }

    //odd, simply first in greater set
    cout << *greater.begin() << endl;
}

void add(multiset<int> &lesser, multiset<int> &greater, int num) {
    //insert appropriately
    if (num < *greater.begin()) {
        lesser.insert(num);
    } else {
        greater.insert(num);
    }
    
    //rebalance
    if (lesser.size() - 1 == greater.size()) {
        int movednum = *(--lesser.end());
        lesser.erase((--lesser.end()));
        greater.insert(movednum);
    } else if (lesser.size() + 2 == greater.size()) {
        int movednum = *greater.begin();
        greater.erase(greater.begin());
        lesser.insert(movednum);
    }
    printmedian(lesser, greater);
}

void remove(multiset<int> &lesser, multiset<int> &greater, int num) {
    //erase from appropriate set
    if (num < *greater.begin()) {
        multiset<int>::iterator it = lesser.find(num);
        if (it == lesser.end()) {
            cout << "Wrong!" << endl;
            return;
        }
        lesser.erase(it);
    } else {
        multiset<int>::iterator it = greater.find(num);
        if (it == greater.end()) {
            cout << "Wrong!" << endl;
            return;
        }
        greater.erase(it);
    }

    //rebalance
    if (lesser.size() - 1 == greater.size()) {
        int movednum = *(--lesser.end());
        lesser.erase((--lesser.end()));
        greater.insert(movednum);
    } else if (lesser.size() + 2 == greater.size()) {
        int movednum = *greater.begin();
        greater.erase(greater.begin());
        lesser.insert(movednum);
    }
    printmedian(lesser, greater);
}

int main(void){
    int opcount;
    cin >> opcount;
    multiset<int> lesser;
    multiset<int> greater;
    char tempop;
    int tempnum;

    for(int i = 0; i < opcount; i++){
        cin >> tempop >> tempnum;
        if (tempop == 'r') {
            remove(lesser, greater, tempnum);
        } else if (tempop == 'a') {
            add(lesser, greater, tempnum);
        }
    }

    return 0;
}
