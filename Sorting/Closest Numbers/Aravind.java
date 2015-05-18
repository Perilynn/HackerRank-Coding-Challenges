import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int smallest = Integer.MAX_VALUE;
        int diff;
        for(int i = 0; i < N-1; i++) {
            diff = nums[i+1] - nums[i];
            if(diff < smallest) smallest = diff;
        }
        for(int i = 0; i < N-1; i++) {
            diff = nums[i+1] - nums[i];
            if(diff == smallest) System.out.print(nums[i] + " " + nums[i+1] + " ");
        }
    }
}