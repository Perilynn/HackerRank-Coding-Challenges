#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*can you find the pair of elements that have the smallest absolute difference between them? If there are multiple pairs, find them all.*/


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int arrSize; 
    cin >> arrSize;
    vector<int> arr;
    
    // Putting ints in the vector
    for (int i = 0; i < arrSize; i++)
    {
        int input;
        cin >> input;
        arr.push_back(input);
    }

    // Sorting
    sort(arr.begin(), arr.end());
    int minVal = abs(arr[1] - arr[0]);
    
    
    // Finding minVal
    vector<int> outputVector;
    for (int i = 0; i < arrSize; i++)
    {
        int currMin = abs (arr[i+1] - arr[i]);
        if (currMin < minVal)
        {
            minVal = currMin;
            // Creating this output vector
            if (outputVector.size() != 0)
            {
                outputVector.pop_back();
                outputVector.pop_back();
            }
            outputVector.push_back(arr[i]);
            outputVector.push_back(arr[i+1]);
        }
    }
    
    // Printing out necessary output
    for (int i = 0; i < outputVector.size(); i++)
    {
        cout << outputVector[i] << " ";
    }
    
    return 0;
}