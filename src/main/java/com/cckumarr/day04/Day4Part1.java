package main.java.com.cckumarr.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 4: Repose Record ---
public class Day4Part1 {
  public static void main(String args[]) throws ParseException, FileNotFoundException {

    //create for non static access
    Day4Part1 day4Part1 = new Day4Part1();
    Scanner in = new Scanner(new File("resources/day4input.txt"));
    //map to hold the class objects
    HashMap<String,Times> map = new HashMap<>();
    //to hold the times object, it does not need to be initialized but my current intellij setting complain its it not initialized
    Times times = new Times("0");

    //to hold the input strings
    ArrayList<String> inputStrings = new ArrayList<>();

    //read input
    while(in.hasNext()){
      String str = in.nextLine();
      inputStrings.add(str);
    }
    //sort input, view day4inputsorted.txt
    inputStrings.sort(String::compareTo);

    //loop de loop, if new guard then create a new times object, then keep looping the sleep and wake times till a new guard is on the block
    //if guard does not sleep this will handle that too
    int count = 0;
    while(count < inputStrings.size()) {
      //System.out.println(inputStrings.get(count));
      if(inputStrings.get(count).contains("Guard")){
        String id = day4Part1.getId(inputStrings.get(count));
        count++;
        if(map.get(id) == null){
          times = new Times(id);
          map.put(id,times);
        }else{
          times = map.get(id);
        }
      }
      else{
        // this will loop only through the sleep wake cycle
        while(count < inputStrings.size() && !inputStrings.get(count).contains("Guard")){
          int start=0,end=0;
          start = day4Part1.getMins(inputStrings.get(count));
          count++;
          end = day4Part1.getMins(inputStrings.get(count));
          //System.out.println(start + " " + end);
          count++;

          //update the mins hashmap and + 1 to the sum
          for(int i =start; i<end; i++){
            times.setMinsValue(i);
          }
        }
      }
    }
    //now we have all the values parsed and in loaded in the times objects

    //to get the max number a guard slept over the input
    int max=0;
    String maxid="";
    for(Times t : map.values()){
      if(t.getSum() > max){
        max = t.getSum();
        maxid = t.getId();
      }
    }

    //display
    System.out.println(maxid + " * " + map.get(maxid).getKeyMaxRepeatedValue()
        + " = " + Integer.parseInt(maxid)*map.get(maxid).getKeyMaxRepeatedValue());


  }

  //parse the string to the get the id which is in between # to the next space
  public String getId(String str){
    int start = str.indexOf("#");
    int count = start;
    while(!String.valueOf(str.charAt(count)).equalsIgnoreCase(" ")){
      count++;
    }
    return(str.substring(start+1,count));
  }

  // get the mins in the str with is in between : and ]
  public int getMins(String str){
    int start = str.indexOf(":");
    int end = str.indexOf("]");

    String mins = str.substring(start+1,end);
    return(Integer.parseInt(mins));
  }
}



/*notes:
1) tried to go step by step without observing that just a direct sort on the string would give me the sorted list instead of converting the string into a date and then sorting the dates, a direct sort of strings did the trick
2) maybe println mistakes and beleived that to be the annswer example belieived 38 * 1733 = 29461 to be correct when verified by calculator then corrected it
3) in part two got excited that i had built it in such a way that i could easily solve it, in the excitement made some mistakes and tooks a while to figure that out
4) did not handle hashmap is empty case before running the input through
*/



//answer : 2039 * 49 = 99911

//part 2 trial answers : 38 * 1733 = 29461