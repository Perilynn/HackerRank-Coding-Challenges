#include<iostream>
#include<algorithm>
#include<list>
#include<vector>
#include<string>
#include<cmath>
#include<cstdint>

int main(int argc, char *argv[]){
    unsigned int n;
    int64_t *a;
    
    std::cin>>n;
    
    if( n == 0) return 0;
    
    a = new int64_t[n];
    
    if( n == 1){
        delete[] a;
        std::cout<<a[0];
        return 0;
    }
    
    for(unsigned int i = 0 ; i < n; i++){
        std::cin>>a[i];
    }
  //edit this as needed, I may have read the question wrong and screwed this part up.
    std::sort(a,a+n);
    
    int64_t min = abs(a[1] - a[0]);
        for(unsigned int i = 1 ; i < n;i++){
            int64_t curMin = abs(a[i-1] - a[i]);
                if(curMin < min){
                    min = curMin;
        }
    }
    
    for(unsigned int i = 1; i < n; i++){
        if(abs(a[i-1] - a[i]) == min){
            std::cout<<a[i-1]<<" "<<a[i]<<" ";
        }
    }
    delete[] a;
    return 0;
} 
//**author: Connie Fan 2015 for SummerofHackRank
