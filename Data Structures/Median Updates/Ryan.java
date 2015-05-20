import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution{
    /* Head ends here*/
    static void median(String a[],int x[]) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("a")) {
                sorted.add(x[i]);
                java.util.Collections.sort(sorted);
            } else if (a[i].equals("r")) {
                if (!sorted.isEmpty()) {
                    sorted.remove((Integer)x[i]);
                }
            }
            if (sorted.isEmpty()) {
                System.out.println("Wrong!");
            } else {
                if (sorted.size() % 2 == 0) {
                    double tot = ((sorted.get(sorted.size() / 2) / 2.0) + (sorted.get(sorted.size() / 2 - 1) / 2.0));
                    System.out.println(tot % 2 == 0 ? (long)(tot) : (double)(tot));
                } else {
                    System.out.println((long)sorted.get(sorted.size() / 2));
                }
            }
        }
       
    }
    
    /* Tail starts here*/
    
   public static void main( String args[] ){
      

      Scanner in = new Scanner(System.in);
      
      int N;
      N = in.nextInt();
   
      String s[] = new String[N];
      int x[] = new int[N];
      
      for(int i=0; i<N; i++){
         s[i] = in.next();
         x[i] = in.nextInt();
      }
   
      median(s,x);
    }
}
