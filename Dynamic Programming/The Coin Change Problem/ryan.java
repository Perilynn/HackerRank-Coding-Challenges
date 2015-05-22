import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n, m;
        n = s.nextInt();
        m = s.nextInt();
        long[] U = new long[m];
        for (int c = 0; c < m; c++) {
            U[c] = s.nextInt();
        }
        long[][] MAT = new long[n+1][m];
        for (int i = 0; i < m; i++) {
            MAT[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int k = 0; k < m; k++) {
                long a, b;
                if (i - U[k] >= 0){
                    a = MAT[i - (int)U[k]][k];
                } else {
                    a = 0;
                }
                if (k >= 1) {
                    b = MAT[i][k-1];
                } else {
                    b = 0;
                }
                MAT[i][k] = a + b;
            }
        }
        System.out.println(MAT[n][m-1]);
    }
}