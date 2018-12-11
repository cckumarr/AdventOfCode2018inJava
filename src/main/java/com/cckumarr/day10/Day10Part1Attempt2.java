package main.java.com.cckumarr.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//--- Day 10: The Stars Align ---
public class Day10Part1Attempt2 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day10input.txt"));

    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();
    ArrayList<Integer> velocityxs = new ArrayList<>();
    ArrayList<Integer> velocityys = new ArrayList<>();

    while(input.hasNext()){
      String str = input.nextLine();

      xs.add(Integer.parseInt(str.substring(str.indexOf("<")+1, str.indexOf(",")).trim()));
      ys.add(Integer.parseInt(str.substring(str.indexOf(",")+1, str.indexOf(">")).trim()));

      velocityxs.add(Integer.parseInt(str.substring(str.lastIndexOf("<")+1, str.lastIndexOf(",")).trim()));
      velocityys.add(Integer.parseInt(str.substring(str.lastIndexOf(",")+1, str.lastIndexOf(">")).trim()));
    }

    int numberOfsecs = 0;
    while(numberOfsecs++ < 100000){
      if(numberOfsecs > 10875) {
        if (numberOfsecs % 10 == 0) {
          for (int i = 0; i < xs.size(); i++) {
            System.out.println("(" + xs.get(i) + "," + ys.get(i) + ")");
          }
        }
      }

      for(int i =0; i<xs.size(); i++) {
        xs.add(i, xs.get(i) + velocityxs.get(i));
        xs.remove(i+1);
        ys.add(i, ys.get(i) + velocityys.get(i));
        ys.remove(i+1);
      }
    }
  }
}

//answer : HKJFAKAF
//used https://www.desmos.com/calculator for visualizing the co-ordinates, check out the image under the day10 folder
// this is not a good way of solving, need to look at another way
/*
tips for future attempt:
keep track of the decreasing coordinates
detect increase in x and y co-ordinates
as soon as it starts increasing store the state
and display from x to y
*/

/*
what i was trying before cleanup:
store all xs, and ys points in hashmap
when multiple value of the hashmap reach certain value cos all characters in the message will be a certain size
this state could possibly be the answer
*/
