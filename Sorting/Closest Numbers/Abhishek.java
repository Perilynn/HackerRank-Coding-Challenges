import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

	public static void main(String[] args) {
		
		//read in values
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int [] array = new int[length];
		for(int i= 0; i<length; i++)
			array[i] = sc.nextInt();
		//sort the array
		Arrays.sort(array);
		int lowest = Integer.MAX_VALUE;

		//iterate through the entire array once to find the smallest difference
		for(int i = 0; i < length-1; i++){
			if(distFunc(array[i], array[i+1]) < lowest)
				lowest = distFunc(array[i], array[i+1]);
		}
		for(int i = 0; i < length-1; i++){
			if(distFunc(array[i], array[i+1]) == lowest)
				System.out.print(array[i] + " " + array[i+1] + " ");
		}			

	}

	public static int distFunc(int x, int y){
		return Math.abs(x - y);
	}
}