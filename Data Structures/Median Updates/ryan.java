import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution{
    /* Head ends here*/
    static void median(String a[],int x[]) {
        //a holds an array of the opcodes
        //x holds the values to add
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++){
            //check the adding condition
            if(a[i].equals("a")){
                vals.add(x[i]);
                Collections.sort(vals);
                printMed(vals);
            }
            //check the removing condition
            else if(a[i].equals("r")){
                
                Integer rem = new Integer(x[i]);
                boolean removed = vals.remove(rem);
                if(!removed) System.out.println("Wrong!");
                else{
                    Collections.sort(vals);
                    printMed(vals);
                }
            }
        }
        
    }
    
    public static void printMed(ArrayList<Integer> nums){
        if(nums.isEmpty()) System.out.println("Wrong!");
        else{
            if(nums.size() %2 == 1)
                System.out.println(nums.get(((nums.size()-1) /2)));
            if(nums.size() % 2 == 0){
                int firstMed = nums.get((nums.size())/2);
                int secondMed = nums.get((nums.size())/2 -1);
                double retval = (firstMed + secondMed)/2.0;
                System.out.println(retval);
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