import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        //read from stdin
        Scanner read = new Scanner(System.in);
        int targetVal = read.nextInt();
        int types = read.nextInt();

        int[] typeList = new int[types];

        //add types of coins to array typeList
        for(int i = 0; i < types; i++){
            typeList[i] = read.nextInt();
        }

        //static method for finding combinations
        findCombinations(typeList, targetVal);
    }

    //static method for finding combinations
    public static void findCombinations(int[] typeList, int targetVal){
        int[] vals = new int[targetVal+1];
        vals[0] = 1;

        for(int j = 0; j < typeList.length; j++){
            for(int q = typeList[j]; q < vals.length;q++ ){
                vals[q] += vals[q-typeList[j]];
                System.out.println("int j = " + j + " int q = " + q + " vals[q] = " + vals[q] + " array = [" + vals[0]+ "," + vals[1]+ ","+vals[2]+ ","+vals[3]+ ","+vals[4] + "]");
            }
        }
        System.out.println(vals[targetVal]);
    }
}