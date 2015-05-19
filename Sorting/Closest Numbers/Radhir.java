import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        
        int[] array = new int[arraySize];
        for(int i = 0; i < arraySize; i++)
        {
            array[i] = scan.nextInt();
        }
        
        Arrays.sort(array);
        
       int minDifference = Integer.MAX_VALUE;
       for(int i = 0; i < array.length - 1; i++)
       {
           if(array[i+1] - array[i] < minDifference)
               minDifference = array[i+1] - array[i];
       }
        
       for(int i = 0; i < array.length - 1; i++)
       {
           if(array[i+1] - array[i] == minDifference)
               System.out.println(array[i] + " " + array[i+1] + " ");
       }
    }
}