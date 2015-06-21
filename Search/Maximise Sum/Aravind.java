import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num >= 0) {
          int N = scan.nextInt();
          long M = (long) scan.nextInt();
          long[] array = new long[N];
          for(int i = 0; i < N; i++) {
            long temp = ((long) scan.nextInt()) % M;
            if(i == 0) array[i] = temp;
            else array[i] = (array[i-1]+temp) % M;
          }
          TreeSet<Long> tset = new TreeSet<Long>();
          long max = 0;
          for(long i: array) {
            if(tset.isEmpty()) {
              max = i;
              tset.add(i);
            }
            else {
              max = Math.max(max, i);
              Long next = tset.ceiling(i+1);
              if(next != null) max = Math.max(max, i - next + M);
              tset.add(i);
            }
          }
          System.out.println(max);
          num--;
        }
    }
}