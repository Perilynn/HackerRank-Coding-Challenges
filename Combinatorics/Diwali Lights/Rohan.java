import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int numOps = keyboard.nextInt();
        
        while(numOps != 0) {
            int numBulbs = keyboard.nextInt();
            long total = 0;
        
            while(numBulbs != 0) {
                total += numBulbs;
                numBulbs--;
            }
        
            long moddedTotal = total % 100000;
            System.out.println(moddedTotal);
        }
        
        
    }
}
