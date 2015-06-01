import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        int[][] grid = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = scan.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) max = Math.max(max, findZoneHelper(grid, i, j, 0, M, N));
            }
        }
        System.out.println(max);
        
    }
    
    public static int findZoneHelper(int[][] grid, int i, int j, int count, int M, int N) {
        if(i < 0 || j < 0 || i >= M || j >= N) return 0;
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        if(grid[i][j] == 0) return 0;
        else return 1 +
            findZoneHelper(grid, i-1, j-1, count, M, N) +
            findZoneHelper(grid, i-1, j, count, M, N) + 
            findZoneHelper(grid, i-1, j+1, count, M, N) + 
            findZoneHelper(grid, i, j-1, count, M, N) + 
            findZoneHelper(grid, i, j, count, M, N) + 
            findZoneHelper(grid, i, j+1, count, M, N) + 
            findZoneHelper(grid, i+1, j-1, count, M, N) + 
            findZoneHelper(grid, i+1, j, count, M, N) + 
            findZoneHelper(grid, i+1, j+1, count, M, N);
    }
}
