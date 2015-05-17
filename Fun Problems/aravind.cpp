
/*
given a char array with extra padded memory and zero byte, 
replace all instances of a period with two semi colons
(c++)
*/

void ReplacePeriods(char* input) {
    int length = strlen(input);
    int indexOn = 2 * length - 1;
    for(int i = length  1; i >= 0; i--) {
        if(input[i] == '.') {
            input[indexOn] = ';';
            input[indexOn - 1] = ';';
            indexOn -= 2;
        }
        else {
            input[indexOn] = input[i];
            indexOn--;
        }
    }
    int i;
    for(int i = 0; i < 2*length - indexOn; i++) {
        input[i] = input[indexOn + 1 + i];
    }
    input[i] = '\0';
}



/*
create an exponent function (x,y) that outputs x ** y.
Make it run in log n instead of n. Able to run negative inputs
*/

long long exponent(long long x, long long y) {
    long long product = 1;
    for(long long i = 0; i < y; i++) {
        product *= x;
    }
    return product;
}

long long exponentLog(long long x, long long y, long long current) {
    if(y == 0) return current;
    else if(y == 1) return x * current;
    else if (y % 2 == 0) exponentLog(x * x, y / 2, current);
    else return exponentLog(x * x, y / 2, current * x);
}

long long exponentLog(long long x, long long y) { 
    return exponentLog(x, y, 1);
}