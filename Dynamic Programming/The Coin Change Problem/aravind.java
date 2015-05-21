import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] coins = new int[M];
        for(int i = 0; i < M; i++) {
            coins[i] = scan.nextInt();
        }
        System.out.println(max(coins, N));
    }
    
    public static int max(int[] coins, int N) {
        int[] numCoins = new int[N+1];
        numCoins[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j < numCoins.length; j++) {
                numCoins[j] += numCoins[j - coins[i]];
            }
        }
        return numCoins[N];
    }
}