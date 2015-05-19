#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <limits>
using namespace std;


int main() {
    int size;
    vector<int> numbers;
    cin >> size;

    //get ints
    for (int i = 0; i < size; i++) {
        int j;
        cin >> j;
        numbers.push_back(j);
    }

    //sort
    sort(numbers.begin(), numbers.end());

    //find min gap
    int mingap = numeric_limits<int>::max();
    for (int i = 0; i < size - 1; i++) {
        if (numbers[i+1] - numbers[i] < mingap)
            mingap = numbers[i+1] - numbers[i];
    }

    //print
    for (int i = 0; i < size - 1; i++) {
        if (numbers[i+1] - numbers[i] == mingap)
            cout << numbers[i] << " " << numbers[i+1] << " ";
    }
        
    return 0;
}
