import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(long n, long[] c){
        long[][] dp = new long[c.length][(int)(n+1)];
        for(int i=0;i<c.length;i++)
            dp[i][0]=1;
        for(int i=1;i<=n;i++){
            if(i%c[0]==0)
                dp[0][i]=1;
            else
                dp[0][i]=0;
        }
        for(int i=1;i<c.length;i++){
            for(int j=1;j<=n;j++){
                if(c[i]>j){
                    //System.out.println("else if");
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-(int)c[i]];
                }
            }
        }
        System.out.println(dp[c.length-1][(int)n]);
        return dp[c.length-1][(int)n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
    }
}

