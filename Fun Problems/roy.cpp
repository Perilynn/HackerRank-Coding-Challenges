// Given a class of Interval, which has start and end point as integer,
// and a list of such Intervals. We want to insert another interval into
// this list of Intervals.
// eg: <4,7><10,15><20,21>
// insert <5, 8>, get <4,8><10,15><20,21>
// insert <16,17>, get <4,8><10,15><16,17><20,21>
// insert <1,30>, get <1,30>

#include <iostream>
#include <vector>
using namespace std;

class Interval {
    public:
        Interval(int a, int b) : lo(a), hi(b) {}
        int lo;
        int hi;
};

void addinterval(vector<Interval> &intervals, Interval a) {
    //bound the intervals that are completely within new interval
    int lowerbound = 0, upperbound = 0;
    for (int i = 0; i < intervals.size(); i++) {
        if(intervals[i].lo < a.lo)
            lowerbound++;
        if(intervals[i].hi < a.hi)
            upperbound++;
    }
    
    //check if the neighboring intervals should be merged, merge if needed
    if (lowerbound > 0 && intervals[lowerbound-1].hi >= a.lo) {
        a.lo = intervals[lowerbound-1].lo;
        lowerbound--;
    }
    if (upperbound < intervals.size() && intervals[upperbound].lo <= a.hi) {
        a.hi = intervals[upperbound].hi;
        upperbound++;
    }
    
    //erase the intervals to be erased, insert new interval with revised bounds
    intervals.erase(intervals.begin() + lowerbound, intervals.begin() + upperbound);
    intervals.insert(intervals.begin() + lowerbound, a);
}

int main() {
    //poorly organized testing code
    vector<Interval> intervalvector;
    Interval a(4,7);
    intervalvector.push_back(a);
    Interval b(10,15);
    intervalvector.push_back(b);
    Interval c(20,21);
    intervalvector.push_back(c);
    for (int i = 0; i < intervalvector.size(); i++)
    cout << "<" << intervalvector[i].lo << "," << intervalvector[i].hi << ">";
    cout << endl;
    Interval d(5,8);
    addinterval(intervalvector, d);
    for (int i = 0; i < intervalvector.size(); i++)
        cout << "<" << intervalvector[i].lo << "," << intervalvector[i].hi << ">";
    cout << endl;
    Interval e(16,17);
    addinterval(intervalvector, e);
    for (int i = 0; i < intervalvector.size(); i++)
    cout << "<" << intervalvector[i].lo << "," << intervalvector[i].hi << ">";
    cout << endl;
    Interval f(1,30);
    addinterval(intervalvector, f);
    for (int i = 0; i < intervalvector.size(); i++)
    cout << "<" << intervalvector[i].lo << "," << intervalvector[i].hi << ">";
    cout << endl;

    return 0;
}
