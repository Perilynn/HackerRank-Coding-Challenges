import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for(int i = 0; i < count; i++) {
        	int N = scan.nextInt();
        	char[][] G = new char[N][N];
        	for(int j = 0; j < N; j++) {
        		String line = scan.next();
        		for(int k = 0; k < N; k++) {
        			G[j][k] = line.charAt(k);
        		}
        		Arrays.sort(G[j]);
        	}
        	boolean possible = true;
        	for(int j = 0; j < N && possible; j++) {
        		for(int k = 1; k < N && possible; k++) {
        			if(Character.compare(G[k][j], G[k-1][j]) < 0) possible = false;
        		}
        	}
        	System.out.println(possible ? "YES" : "NO");
        }
    }
}