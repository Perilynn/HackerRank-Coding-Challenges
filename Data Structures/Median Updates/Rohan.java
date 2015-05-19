import java.io.*;
import java.util.*;

public class Solution {
    
    String[] operations;
    int[] nums;
    List<Integer> data;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int numOps = keyboard.nextInt();
        
        operations = new String[numOps];
        nums = new int[numOps];
        data = new ArrayList<Integer>();
        
        for(int i = 0; i < numOps; i++) {
            operations[i] = keyboard.next();
            nums[i] = keyboard.nextInt();
            doStuff(i);
        }
    }
    
    public static void doStuff(int i) {
        if(operations[i].equals("r")) {
            boolean found = false;
            for(int num : data) {
                if(num == nums[i]) {
                    found = true;
                    data.remove(num);
                }
            }
            if(!found) {
                System.out.println("Wrong!");
            } else {
                Collections.sort(data);
                double median;
                if(i % 2 == 0) {
                    // actually means it is odd, fuck zero indexing
                    int medianLoc = i / 2;
                    median = data.get(medianLoc);
                } else {
                    int medianLoc = i / 2;
                    int secondMedianLoc = medianLoc + 1;
                    int firstMedian = data.get(medianLoc);
                    int secondMedian = data.get(secondMedianLoc);
                    median = (firstMedian + secondMedian) / 2;
                }
                System.out.println(median);
            }
        } else if(operations[i].equals("a")) {
            data.add(nums[i]);
        }
    }
}
