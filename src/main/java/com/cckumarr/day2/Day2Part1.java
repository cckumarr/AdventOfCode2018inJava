package main.java.com.cckumarr.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 2: Inventory Management System ---
public class Day2Part1 {
 public static void main(String args[]) throws FileNotFoundException {
   Scanner in = new Scanner(new File("resources/day2input.txt"));

   int totalTwos =0, totalThrees=0;


   while(in.hasNext()){
     HashMap<Character,Integer> map = new HashMap<>();
     int twos=0,threes=0;

     String str = in.nextLine();
     System.out.println(str);
     for(Character c : str.toCharArray()){

       if(map.get(c) != null){
         int count = map.get(c);
         map.put(c,++count);
         if(count==2){
          twos++;
         }
         if(count==3){
           threes++;
           twos--;
         }
       }
       else{
         map.put(c,1);
       }
     }
     if(twos>=1){
       totalTwos++;
     }
     if(threes>=1){
       totalThrees++;
     }
   }
   System.out.println(totalTwos * totalThrees);
 }
}


//answer 6696
