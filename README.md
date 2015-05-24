# HackerRank Coding Challenges

We're going to be doing a HackerRank challenge every day!

I'll post the challenge we'll be doing every day. Commit your solution file into the appropriate folder with your name as the file name.
For example, a submission could be Aravind.java or Naren.py.
If you have any questions on the daily challenge, feel free to reach out to anyone else working on it. 


# Setting up the Challenge repo locally:

go to your command line, and navigate into the folder you want it.

run this:
`git clone https://github.com/Perilynn/HackerRank-Coding-Challenges.git`

When you want to submit your code, drop the file into the corresponding sub-folder (e.x. Combinatorics, Sorting, etc.), and run the following:

```
git add YourName.filetype       //e.x. Aravind.java
git commit -m "submission"
git pull                // to prevent conflicts, always pull first
git push origin master
```
# Problems Covered:
1. Closest Number - 5/18/15
  * Catagory: Sorting
  * https://hackerrank.com/challenges/closest-number
2. Median Updates - 5/19/15
  * Catagory: Data Structures
  * https://hackerrank.com/challenges/median-updates
3. Diwali Lights - 5/20/15
  * Catagory: Combinatorics
  * https://hackerrank.com/challenges/diwali-lights 
4. Coin Challenge - 5/21/15
  * Catagory: Dynamic Programming
  * https://hackerrank.com/challenges/coin-challenge
5. The Trigonometric Ratios (Code Golf)
  * https://www.hackerrank.com/challenges/trignometric-ratios
  * Code Golf is a special kind of problem. Your score on the challenge is based on the number of lines it takes to solve the problem. The less lines, the higher the score (just like golf!). Of course, your code also has to solve the challenge correctly. You have until Sunday night for this challenge, so have at it!
  * PUT YOUR SCORE IN YOUR FILE AS WELL!!!!!
  
#Fun Problems:
1. Create an exponent function ```exp(x,y)``` that does x^y in O(log n) time
2. Given a char array with padded memory and a zero byte, replace all '.' with ';;'
  * E.g input might be:
  * |Index|  0  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
  * |Value| \0  | - | r | - | 5 | - | . | - | 4 |
  * Outputs: [\0,r,5,;,;,4]
3. Given a class ```Interval``` which has a start and end point as int and a list of such ```Interval```s, write a method to insert another ```Interval``` into the list
  * E.g <4,7><10,15><20,21>
  * insert <5,8> gets <4,8><10,15><20,21>
  * insert <16,17> gets <4,8><10,15><16,17><20,21>
  * insert <1,30> gets <1,30>
4. In a tree of nodes, where each node is defined as
```
class node
{
  public:
    int value;
    vector <node*> children
    vector <node*> siblings
};
```
assume given a tree, all nodes have their children vectors filled.
fill their siblings vector

5.
Convert string to int manually, and convert an int to a string manually

E.x. "123" (type string) to 123 (type int)

and 123 (type int) to "123" (type string)
(boilerplate c++ example)
```
int toInt(string x) {
  //your code here
}

string toString(int x) {
  //your code here
}
```

6. 
Boolean function isNumber. given a string, return true if it is a
valid number, return false if not. dont forget to account negatives
and decimals