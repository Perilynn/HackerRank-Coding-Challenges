import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int numOps = keyboard.nextInt();
        while(numOps != 0) {
            int numBulbs = keyboard.nextInt();
            int total = 0;
            total = ((numBulbs * 2) - 1) % 100000;
            System.out.println(total);
            numOps--;
        }
    }
}
