	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;
	
	public class Peter {

	    public static void main(String[] args) {
	        int min = (2 * Integer.MAX_VALUE);
	        Scanner sc = new Scanner(System.in);
	        int length = sc.nextInt();
	        ArrayList<Integer> data = new ArrayList<Integer>(); //creates arraylist of provided length
	        for (int i = 0; i < length; i++) {
	            data.add(sc.nextInt()); //fills the arraylist with the inputs
	        }
	        Collections.sort(data); //sort :) thanks for the tip bbs
	        for (int j = 0; j < length - 1; j++) {
	            if(Math.abs(data.get(j) - data.get(j+1)) < min) {
	                min = Math.abs(data.get(j) - data.get(j+1)); //finds the smallest possible difference
	            }
	        }
	        for (int k = 0; k < length - 1; k++) {
	            if(Math.abs(data.get(k) - data.get(k+1)) == min) {
	                System.out.print(data.get(k) + " " + data.get(k+1) + " ");
	            }
	        }
	    }
	}
