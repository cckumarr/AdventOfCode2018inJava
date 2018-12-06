package main.java.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    Day5Part2 day5Part2 = new Day5Part2();
    Scanner in = new Scanner(new File("day5input.txt"));
    //since it only one line
    String input = in.nextLine();
    //String input = "dabAcCaCBAcCcaDA";

    int character = 65;
    int minLength=Integer.MAX_VALUE;
    while(character <= 90){
      System.out.println(character);
      //remove char from string
      String withoutChar = day5Part2.removeCharacter(character,input);
      //System.out.println(withoutChar);
      //alchemize that string
      String finalString = day5Part2.alchemize(withoutChar);
      //System.out.println(finalString);
      if(finalString.length() < minLength)
        minLength=finalString.length();
      character++;
    }
    System.out.println("min length = "+ minLength);
  }

  public String removeCharacter(int character, String str){
    String deChared="";
    for(char c : str.toCharArray()){
      int value = c;
      if(value != character && value - 32 != character && value + 32 != character){
        deChared = deChared + c;
      }
    }
    return deChared;
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


//answer : min length = 5310