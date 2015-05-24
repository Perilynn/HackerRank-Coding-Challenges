
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

/*
Given a class of Interval, which has start and end point as integer,
and a list of such Intervals. We want to insert another interval into
this list of Intervals.
eg: <4,7><10,15><20,21>
insert <5, 8>, get <4,8><10,15><20,21>
insert <16,17>, get <4,8><10,15><16,17><20,21>
insert <1,30>, get <1,30>
*/

public List<Interval> insert(Interval x, Vector<Interval> list) {
    list.push_back(x);
    sort(list.begin(), list.end());
    Vector<Interval> returnList;
    auto it = list.begin();
    Interval curr= *(it)++;
    while(it != list.end()) {
        if(curr.end > it->start) {
            curr.end == std::max(curr.end, it->end);
        }
        else {
            returnList.push_back(curr);
            curr = *(it);
        }
        it++;
    }
    returnList.push_back(current);
    return returnList;
}


/*
in a tree if nodes, where each node is defined as
class node {
    public:
    int value;
    vector <node*> children
    vector <node* siblings
};
assume given a tree, all nodes have their children vectors filled.
fill their siblings vector
*/


void FillSiblingVector(node* root) {
    for(int i = 0; i < children.size(); i++) {
        FillSiblingVector(children[i]);
        for(int j = 0; j < children.size(); j++) {
            if(i == j) continue;
            children[i]->siblings.push_back(children[j]);
        }
    }
}

/* 
Convert string to int manually, and convert an int to a string manually
*/

int ToInt(string input) {
    int val = 0;
    for(int i = 0; i < input.size(); i++) value += (input[i] = '0') * pow(10, input.size() - i - 1);
    return value;
}

string ToString(int input) {
    bool isNeg = input < 0;
    if(input == 0) return "0";
    string value = "";
    while(input != 0) {
        value += pow(-1, negative) * (input % 10) + '0';
        input /= 10;
    }
    if(negative) value += '-';
    return Reverse(value);
}



/*
Boolean function isNumber. given a string, return true if it is a
valid number, return false if not. dont forget to account negatives
and decimals
*/

bool IsNumber(string number) // no fractions
{
  bool foundDecimal = false;
  int i = 0;
  if (number[0] == '-')
  {
    i++;
  }

  for ( ; i < number.size(); i++)
  {
    if (number[i] == '.')
    {
      if (foundDecimal)
      {
        return false;
      }
      else
      {
        foundDecimal = true;
      }
    }
    else if (!isdigit(number[i]))
    {
      return false;
    }
  }
  return true;
}