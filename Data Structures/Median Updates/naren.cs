using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
class Solution {

   static void Main(String[] args) {
      StringBuilder str = new StringBuilder();
      int N = Convert.ToInt32(Console.ReadLine());
      int[] size = new int[N];
      List<double> data = new List<double>();
      string[] commands = new string[N];
      for(int i = 0; i < N ; i++){
            string tmp = Console.ReadLine(); 
            string[] parse = tmp.Split(new Char[] {' ', '\t', '\n'});
            commands[i] = parse[0].Trim();
            size[i] = Convert.ToInt32(parse[1].Trim());
            bool rem = true;
            if(commands[i] == "r"){
                int index = data.BinarySearch(size[i]);
                if(index >= 0){
                    data.RemoveAt(index);   
                }
                else{
                    rem = false;
                }
            }
            else{
                var index = data.BinarySearch(size[i]);
                if (index < 0){
                    index = ~index;
                }
                data.Insert(index, size[i]);
            }
            if(!rem || data.Count == 0){
                str.AppendLine("Wrong!");
            }
            else{
                str.AppendLine(calcularModa(data).ToString());
            }
        }      
        Console.WriteLine(str.ToString());
    }
    static double calcularModa(List<double> data){
        int i= data.Count/2;
        if(data.Count % 2 != 0){
            return data[i];
        }
        else{
            return ((data[i - 1] + data[i]))/2;
        }
    }
}
