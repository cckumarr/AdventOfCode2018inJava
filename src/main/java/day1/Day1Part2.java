package main.java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//
public class Day1Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in;

    HashMap<Integer,Integer> map = new HashMap<>();
    int frequency=0;
    Boolean found=false;

    while(!found){
      in = new Scanner(new File("day1input.txt"));
      while(in.hasNextInt() && !found){
        frequency += in.nextInt();
        if(map.get(frequency)!=null){
          System.out.println(frequency);
          found =true;
          break;
        }
        map.put(frequency,1);
      }
    }
  }
}


//answer: 287