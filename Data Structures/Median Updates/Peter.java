import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution{
    /* Head ends here*/
    static void median(String a[],int x[]) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        boolean flag = false;
        for(int i = 0; i < a.length; i++) {
            if(a[i].equals("a")) {
                nums.add(x[i]);
                Collections.sort(nums);
                if(nums.size() % 2 == 1 && nums.size() != 1) {
                    System.out.println(nums.get(nums.size()/2));
                }
                if(nums.size() == 1) {
                    System.out.println(nums.get(0));
                }
                if(nums.size() % 2 == 0 && nums.size() != 0) {
                    System.out.println((((double)(nums.get(nums.size()/2 - 1))) + (double)(nums.get(nums.size()/2)))/2.0);
                }
            }
            if(a[i].equals("r")) {
               for(int j = 0; j < nums.size(); j++) {
                    if(x[i] == nums.get(j)) {
                        flag = true;
                        nums.remove(j);
                         if(nums.size() % 2 == 1 && nums.size() != 1) {
                             System.out.println(nums.get(nums.size()/2));
                         }
                        if(nums.size() == 1) {
                             System.out.println(nums.get(0));
                        }  
                         if(nums.size() % 2 == 0 && nums.size() != 0) {
                             System.out.println((((double)(nums.get(nums.size()/2 - 1))) + (double)(nums.get(nums.size()/2)))/2.0);
                         }
                    }
                }
                if(flag == false || nums.size() == 0) {
                    System.out.println("Wrong!");
                }
                flag = true;
            }
        }
       
    }
    
    /* Tail starts here*/
    
   public static void main( String args[] ){
      

      Scanner in = new Scanner(System.in);
      
      int N;
      N = in.nextInt(); //number of operations
   
      String s[] = new String[N]; //letter
      int x[] = new int[N]; //number
      
      for(int i=0; i<N; i++){
         s[i] = in.next();
         x[i] = in.nextInt();
      }
   
      median(s,x);
    }
}
