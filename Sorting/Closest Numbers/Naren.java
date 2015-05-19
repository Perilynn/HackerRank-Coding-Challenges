import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] data = new int[size];
        for(int i = 0; i < size; i++){
            data[i] = in.nextInt();
        }
        Arrays.sort(data);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < size; i++){
           if(Math.abs(data[i] - data[i-1]) <= min){
              min = Math.abs(data[i] - data[i-1]);
           }
        }
        for(int i = 1; i < size; i++){
           if(Math.abs(data[i] - data[i-1]) == min){
               System.out.print(data[i-1] + " " + data[i] + " ");
           }
        }
    }

}
