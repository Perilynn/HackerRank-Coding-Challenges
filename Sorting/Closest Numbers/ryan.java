import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        s.nextLine();
        String input = s.nextLine();
        String[] splinput = input.split("\\s+");
        Integer[] integers = new Integer[size];
        for(int i = 0; i < size; i++) {
            integers[i] = Integer.parseInt(splinput[i]);
        }
        java.util.Arrays.sort(integers);
        int min = Integer.MAX_VALUE;
        ArrayList<Pair> sol = new ArrayList<Pair>();
        for (int i = 0; i < size -1; i++) {
            if (integers[i+1] - integers[i] < min) {
                sol.clear();
                min = integers[i+1] - integers[i];
                sol.add(new Pair(integers[i], integers[i+1]));
            } else if (integers[i+1] - integers[i] == min) {
                sol.add(new Pair(integers[i], integers[i+1]));
            }
        }
        for (Pair p : sol) {
            System.out.print(p.toString());
        }
        
    }
    
    public static class Pair {
        private int l;
        private int r;
        Pair(int a, int b) {
            l = a;
            r = b;
        }
        
        public String toString() {
            return "" + l + " " + r + " ";
        }
    }
}