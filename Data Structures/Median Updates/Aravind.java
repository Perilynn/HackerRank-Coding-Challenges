import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution{
    /* Head ends here*/
    static void median(String a[],long x[]) {
        List<Long> nums = new ArrayList<Long>();
        for(int i = 0; i < a.length; i++) {
            updateMedian(a[i], x[i], nums);
        }
       
    }
    
    public static void updateMedian(String str, long num, List<Long> nums) {
        int index = Collections.binarySearch(nums, num);
        if(str.equalsIgnoreCase("r")) {
            if(index < 0) {
                System.out.println("Wrong!");
                return;
            }
            else nums.remove(index);
        }
        else {
            if(index < 0) nums.add(- index - 1, num);
            else nums.add(index, num);
        }
        if(nums.size() == 0) System.out.println("Wrong!");
        else if (nums.size() % 2 == 0) {
            long median = (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1));
            if((median & 1) == 1) {
                System.out.printf("%.1f", median/2.0);
                System.out.println();
            }
            else System.out.println(median / 2);
        }
        else System.out.println(nums.get((nums.size() - 1)/2));
    }
   public static void main( String args[] ){
      

      Scanner in = new Scanner(System.in);
      
      int N;
      N = in.nextInt();
   
      String s[] = new String[N];
      long x[] = new long[N];
      
      for(int i=0; i<N; i++){
         s[i] = in.next();
         x[i] = in.nextLong();
      }
   
      median(s,x);
    }
}
