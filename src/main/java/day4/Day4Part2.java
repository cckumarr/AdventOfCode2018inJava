package main.java.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 4: Repose Record ---
public class Day4Part2 {
  public static void main(String args[]) throws ParseException, FileNotFoundException {

    Day4Part1 day4Part1 = new Day4Part1();
    Scanner in = new Scanner(new File("day4input.txt"));
    //ArrayList<Date> time = new ArrayList<>();
    HashMap<String,Times> map = new HashMap<>();
    Times times = new Times("0");

    ArrayList<String> list = new ArrayList<>();

    //read input
    while(in.hasNext()){
      String str = in.nextLine();
      list.add(str);
    }
    //sort input
    list.sort(String::compareTo);

    /*for(String s : list){
      System.out.println(s);
    }*/

    int count = 0;
    while(count < list.size()) {
      //System.out.println(list.get(count));
      if(list.get(count).contains("Guard")){
        String id = day4Part1.getId(list.get(count));
        //day4part1.getTime((list.get(count)));
        count++;
        if(map.get(id) == null){
          times = new Times(id);
          map.put(id,times);
        }else{
          times = map.get(id);
        }
      }
      else{
        while(count < list.size() && !list.get(count).contains("Guard")){
          int start=0,end=0;
          start = day4Part1.getMins(list.get(count));
          count++;
          end = day4Part1.getMins(list.get(count));
          //System.out.println(start + " " + end);
          count++;

          for(int i =start; i<end; i++){
            times.setMinsValue(i);
          }
        }
      }
    }


    //part2 of the problem
    int maxRepetitionsinmin=0;
    String idofthatmin="";
    System.out.println("minute " + "reps " + "id");
    for(Times t : map.values()){
      int temp = t.getMaxRepeatedValue();
      if(temp > maxRepetitionsinmin){
        maxRepetitionsinmin = temp;
        idofthatmin = t.getId();
      }
      System.out.println(map.get(t.getId()).getKeyMaxRepeatedValue() +" " + temp + " " + t.getId());
    }

    int value = map.get(idofthatmin).getKeyMaxRepeatedValue();

    System.out.println(value + " * " + idofthatmin +" = "+ value * Integer.parseInt(idofthatmin));

  }

  public String getTime(String str){
    int start = str.indexOf("[");
    int end = str.indexOf("]");

    String time = str.substring(start+1,end);
    return(time);
  }

  public String getId(String str){
    int start = str.indexOf("#");
    int count = start;
    while(!String.valueOf(str.charAt(count)).equalsIgnoreCase(" ")){
      count++;
    }
    return(str.substring(start+1,count));
  }

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


//2 nr tried answer : 2039 * 49 = 99911

//part 2 trial answers : 38 * 1733 = 29461


//38 * 1733 = 65854 not 29461