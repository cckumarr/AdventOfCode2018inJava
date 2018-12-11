package main.java.com.cckumarr.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//--- Day 5: Alchemical Reduction ---
public class Day5part1 {
  public static void main(String args[]) throws FileNotFoundException {
    Day5part1 day5part1 = new Day5part1();
    Scanner in = new Scanner(new File("resources/day5input.txt"));
    //since it only one line
    String input = in.nextLine();
    //String input = "dabAcCaCBAcCcaDA";

    String finalValue = day5part1.alchemize(input);
    System.out.println(finalValue);
    System.out.println(finalValue.length());
  }

  public String alchemize(String str){

    String finalstr=str;
    String returnstr="";
    boolean reactions=true;
    int count;
    while(reactions) {
      reactions=false;
      count=0;
      returnstr="";
      while (count < finalstr.length() - 1) {
        int current = finalstr.charAt(count);
        int next = finalstr.charAt(count + 1);
        if (current + 32 != next && current - 32 != next ) {
          returnstr = returnstr + finalstr.charAt(count);
        } else {
          reactions=true;
          count++;
        }
        count++;
        if(count == finalstr.length()-1){
          returnstr = returnstr + finalstr.charAt(count);
        }
      }
      finalstr=returnstr;
    }
    return returnstr;
  }
}



// A : 65 a : 97

//answer : 11894

/*
notes:
1) did not focus on resetting the values in the while loop
2) kept adding values to the same string making it an infinite loop
3) add counters immidetely after starting the while loop*/


//need to try as a recursive function