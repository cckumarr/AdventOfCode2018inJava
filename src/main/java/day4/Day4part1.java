package main.java.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 4: Repose Record ---
public class Day4part1 {
  public static void main(String args[]) throws ParseException, FileNotFoundException {

    Day4part1 day4part1 = new Day4part1();
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

    int count = 0;
    while(count < list.size()) {
      //System.out.println(list.get(count));
      if(list.get(count).contains("Guard")){
        String id = day4part1.getId(list.get(count));
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
          start = day4part1.getMins(list.get(count));
          count++;
          end = day4part1.getMins(list.get(count));
          //System.out.println(start + " " + end);
          count++;

          for(int i =start; i<end; i++){
            times.setMinsValue(i);
          }
        }
      }
    }


    int max=0;
    String maxid="";
    for(Times t : map.values()){
      if(t.getSum() > max){
        max = t.getSum();
        maxid = t.getId();
      }
    }

    System.out.println(maxid + " * " + map.get(maxid).getKeyMaxRepeatedValue()
        + " = " + Integer.parseInt(maxid)*map.get(maxid).getKeyMaxRepeatedValue());


/*    //part2 of the problem
    int max2=0;
    String maxid2="";
    for(Times t : map.values()){
      if(t.getKeyMaxRepeatedValue() > max2){
        max2 = t.getKeyMaxRepeatedValue();
        maxid2 = t.getId();
      }
    }

    System.out.println(max2 + " " + maxid2 +" = "+ max2 * Integer.parseInt(maxid2));*/

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




//notes:



//answer : 2039 * 49 = 99911