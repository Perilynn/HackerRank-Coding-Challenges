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
  * https://hackerrank.com/challenges/closest-number
2. Median Updates - 5/19/15
  * https://hackerrank.com/challenges/median-updates  
3. Diwali Lights - 5/20/15
  * https://hackerrank.com/challenges/diwali-lights 
4. Coin Challenge - 5/21/15
  * https://hackerrank.com/challenges/coin-challenge
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
  *insert <1,30> gets <1,30>
