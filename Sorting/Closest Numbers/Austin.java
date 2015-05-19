import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {

        //Read in values
        Scanner read = new Scanner(System.in);
        int arraySize = read.nextInt();
        int[] numbers = new int[arraySize];
        for(int i=0; i < arraySize; i++) {
            numbers[i] = read.nextInt();
        }

        Arrays.sort(numbers);
        int lo = Integer.MAX_VALUE; //Assign highest possible number to int counter

        //Iterate to find smallest difference
        for(int j = 1; j < arraySize; j++){
            if(diff(numbers[j-1],numbers[j]) < lo){
                lo = diff(numbers[j-1],numbers[j]);
            }
        }

        //Iterate to find smallest pairs
        String solution = "";
        for(int j = 1; j < arraySize; j++){
            if(diff(numbers[j-1],numbers[j]) == lo){
                solution += (numbers[j-1]+ " " + numbers[j] + " ");
            }
        }

        //delete trailing whitespace, problem statement specifies
        System.out.println(solution.trim());
    }

    //Static method for calculating absolute difference RF
    public static int diff(int x, int y){
        return Math.abs(Math.abs(x) - Math.abs(y));
    }
}