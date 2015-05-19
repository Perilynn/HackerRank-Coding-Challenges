import java.util.*;
import java.io.*;
import java.math.*;

public class ClosestNums {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int size = keyboard.nextInt();
        
        int[] numbers = new int[size];
        int minVal = Integer.MAX_VALUE;
        
        for(int i = 0; i < size; i++){
            numbers[i] = keyboard.nextInt();
        }
        
        Arrays.sort(numbers);
       
        for(int i = 1; i < size; i++){
           if(Math.abs(numbers[i] - numbers[i-1]) < minVal){
              minVal = Math.abs(numbers[i] - numbers[i-1]);
           }
        }
        
        for(int i = 1; i < size; i++){
           if(Math.abs(numbers[i] - numbers[i-1]) == minVal){
               System.out.print(" " + numbers[i-1] + " " + numbers[i]);
           }
        }
    }
}
