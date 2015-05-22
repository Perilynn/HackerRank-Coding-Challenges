import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution{
    public static void main( String args[] ){
        List<Integer> dynamicList = new ArrayList(); // holds list of numbers
        // READ OPERATIONS
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        String actions[] = new String[N];
        int numbers[] = new int[N];
        for(int i=0; i<N; i++){
            actions[i] = in.next();
            numbers[i] = in.nextInt();

            //updates dynamic list every iteration
            update( dynamicList, actions[i], numbers[i]);

            //gets the median if there are numbers in the dynamic list, edge case accounted for in update
            if(dynamicList.size() > 0){

                //prints median
                getMedian(dynamicList);
            }
        }
    }

    // BEGINNING OF STATIC METHODS


    // Calculates Median
    static void getMedian(List<Integer> dynamicList){
        Collections.sort(dynamicList);
        int size = dynamicList.size();
        if(size%2 == 0){ //even
            double median; //not always a double, but too lazy to fix
            median = ((double)dynamicList.get(size/2) + (double)dynamicList.get(size/2 - 1))/2;
            System.out.println(median);
        }
        else{ //odd, will always be an integer
            int median;
            median = dynamicList.get(size/2);
            System.out.println(median);
        }
    }


    // Updates dynamic list
    static void update(List<Integer> dynamicList, String actions,int numbers) {
        int size = dynamicList.size();
        if(actions.equals("a")){
            dynamicList.add(numbers);
        }
        if(actions.equals("r")){
            if(size == 0){
                System.out.println("Wrong!");
            }
            else{
                if(dynamicList.contains(numbers)){
                    dynamicList.remove(new Integer(numbers));
                    if(dynamicList.size() == 0){
                        System.out.println("Wrong!"); // when list is empty after removal
                    }
                }
                else{
                    System.out.println("Wrong!"); //when trying to remove from empty list
                }
            }
        }
    }
}
