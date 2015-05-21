import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int numOps = keyboard.nextInt();
        while(numOps != 0) {
            System.out.println((((keyboard.nextInt() * 2) - 1) % 100000));
            numOps--;
        }
    }
}
