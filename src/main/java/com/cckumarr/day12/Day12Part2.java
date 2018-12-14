package main.java.com.cckumarr.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 12: Subterranean Sustainability ---
public class Day12Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    //String inputStr = "#..#.#..##......###...###";
    String inputStr = "#.......##.###.#.#..##..##..#.#.###..###..##.#.#..##....#####..##.#.....########....#....##.#..##...";
    System.out.println(inputStr);
    Scanner inputSpread = new Scanner(new File("resources/day12input.txt"));
    HashMap<String,String> spread = new HashMap<>();
    //Long generations = 50000000000L;
    Long generations = 107L;

    while(inputSpread.hasNext()){
      String[] str = inputSpread.nextLine().split(" ");
      spread.putIfAbsent(str[0],str[2]);
    }

    StringBuilder sb = new StringBuilder(inputStr);
    int startindex=0;
    int numberOfDotsTruncated=0;

    long generation = 0;
    while(generation++<generations) {
      int firstPotLocation = sb.indexOf("#");
      if (firstPotLocation <= 3) {
        for(int i =0; i <4-firstPotLocation;i++) {
          sb.insert(0, ".");
          startindex++;
        }
      }
      if (firstPotLocation >= 10) {
        String substring = sb.substring(firstPotLocation - 5,sb.length());
        numberOfDotsTruncated +=5;
        sb = new StringBuilder(sb.substring(firstPotLocation - 5,sb.length()));
      }
      if(sb.lastIndexOf("#") >= sb.length()-4){
        for(int i =0; i <4;i++) {
          sb.append(".");
        }
      }
      String parsing = sb.toString();
      //System.out.println(generation + " : "+sb.toString());
      for (int i = 2; i < parsing.length() - 2; i++) {
        String substring = parsing.substring(i - 2, i + 3);
        String value = spread.get(substring);
        if (value != null) {
          sb.setCharAt(i, value.charAt(0));
        }
        else{
          sb.setCharAt(i, '.');
        }
      }

      //if(generation%10000 == 0)
      //System.out.println(generation + " "+ startindex+" "+ sb.indexOf("#") +" : " + sb.toString());
        System.out.println(generation + " "+ numberOfDotsTruncated +" "+ startindex +" : "+sb.toString());

    }

    int index=0;
    String s = sb.toString();
    long sum=0;
    while(index < s.length()-1){
      if(s.charAt(index) == '#'){
        sum += index - startindex;
      }
      index++;
    }

    System.out.println(sum);
  }
}



/*
observations:
. keep increasing on the left
after a while the same pattern keeps getting right shifted
    by how many ? 1

find when the pattern remains same ?
seems to settles down at 107
106 : .....#.#....##.#....##.#....##.#....##.#....##.#.....##.#........##.#....##.#.....###.#....###.#....###.#....###.#....##.#....##.#....##.#....##.#....###.#....##.#....##.#.....
107 : ....##..#....##.#....##.#....##.#....##.#....##.#.....##.#........##.#....##.#.....###.#....###.#....###.#....###.#....##.#....##.#....##.#....##.#....###.#....##.#....##.#....
108 : ......##.#....##.#....##.#....##.#....##.#....##.#.....##.#........##.#....##.#.....###.#....###.#....###.#....###.#....##.#....##.#....##.#....##.#....###.#....##.#....##.#...
109 : .......##.#....##.#....##.#....##.#....##.#....##.#.....##.#........##.#....##.#.....###.#....###.#....###.#....###.#....##.#....##.#....##.#....##.#....###.#....##.#....##.#......

this has to be solve by some math not by running to 5Bil

at generation 108  = 7976 then increases by 65 each time

could calculate to 200 correctly, so (5bil - 108) * 65 + 7976(which is values before 108 when there were changes)

answer : 3250000000956
*/