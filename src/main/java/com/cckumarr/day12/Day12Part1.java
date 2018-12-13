package main.java.com.cckumarr.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//--- Day 12: Subterranean Sustainability ---
public class Day12Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    //test string
    //String inputStr = "#..#.#..##......###...###";
    String inputStr = "#.......##.###.#.#..##..##..#.#.###..###..##.#.#..##....#####..##.#.....########....#....##.#..##...";
    System.out.println(inputStr);
    Scanner inputSpread = new Scanner(new File("resources/day12input.txt"));
    HashMap<String,String> spread = new HashMap<>();
    int generations =20;

    while(inputSpread.hasNext()){
      String[] str = inputSpread.nextLine().split(" ");
      spread.putIfAbsent(str[0],str[2]);
    }

    StringBuilder sb = new StringBuilder(inputStr);
    int startindex=0;

    long generation = 0;
    while(generation++<generations) {
      int firstPotLocation = sb.indexOf("#");
      if (firstPotLocation < 4) {
        for(int i =0; i <4;i++) {
          sb.insert(0, ".");
          startindex++;
        }
      }
      if(sb.lastIndexOf("#") >= sb.length()-4){
        for(int i =0; i <4;i++) {
          sb.append(".");
        }
      }
      String parsing = sb.toString();
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

      System.out.println(generation +" : "+sb.toString());
    }

    int index=0;
    String s = sb.toString();
    int sum=0;
    while(index < s.length()-1){
      if(s.charAt(index) == '#'){
          sum += index - startindex;
        }
      index++;
    }

    System.out.println(sum);
  }
}


/*why not using a string/stringbuilder ?
    cons: bcos i dont know of a way to track of the starting element if we keep adding pots to the left, umm find a way ??!!
    pros: easier to use
why not use an arraylist ?
  cons : because adding elements to the start of the list is O n and extra efforts to keep track of starting position
    pros:
why use linkedlist
  pros : insertions are O 1, can keep track of the initial node
  cons : looping through it


#.......##.###.#.#..##..##..#.#.###..###..##.#.#..##....#####..##.#.....########....#....##.#..##...
1 : ...#.#.......#..####......#...###.##.#.#..#.#..###......#.....##.#..##.#......#####.#..#.#....##.....#......
2 : ......##..#.....#.....#.#....#.##..##..###...##.....#.#....#.#.....##....##.#.......####..##..#.....#...#.#.....
3 : ........##.#...#.#...##..#..###..#...#..#.##...#...##..#..##..#......#....##.#........#.#...##.#...#.####..#....
4 : .........##.####..##...##....#.##.###..###..###.##...##.....##.#....#.#....##.#......##..##..##.#####..#.##.#...
5 : ..........#...#.#...##...#..###.#..#.#..#.#..##...##...#.....##.#..##..#....##.#.......#...#..#...##.####.##.#......
6 : .........#.####..##...###....###..##...##......##...###.#.....##.....##.#....##.#.....#.###..#.##..#...##..##.#.....
7 : ........###..#.#...##..#.#....#.#...##...#.......##..###.#......#.....##.#....##.#...###.#.####..##.##...#..##.#....
8 : .........#.###..##...###..#..##..##...###.#........#..###.#....#.#.....##.#....##.##..#####..#.#..#...###....##.#...
9 : ........###.#.#...##..#.##.....#...##..###.#......#....###.#..##..#.....##.#....#...#...##.###...#.##..#.#....##.#......
10 : .........####..##...####..#...#.##...#..###.#....#.#....###.....##.#.....##.#..#.###.##..#..#.#####..###..#....##.#.....
11 : ...........#.#...##...#.##.#####..###....###.#..##..#....#.#.....##.#.....##..###.##...##..###..##.#..#.##.#....##.#....
12 : ..........##..##...#####.#...##.#..#.#....###.....##.#..##..#.....##.#......#..##...##...#..#.#..##..###.##.#....##.#...
13 : ............#...##...####.##..##..##..#....#.#.....##.....##.#.....##.#....#.....##...###..##......#..##..##.#....##.#......
14 : ...........#.##...##...##...#...#...##.#..##..#......#.....##.#.....##.#..#.#......##..#.#...#....#.....#..##.#....##.#.....
15 : ..........###..##...##...###.###.##..##.....##.#....#.#.....##.#.....##..##..#.......###..###.#..#.#...#....##.#....##.#....
16 : ...........#.#...##...##..##..##...#...#.....##.#..##..#.....##.#......#...##.#.......#.#..###..##..###.#....##.#....##.#...
17 : ..........##..##...##...#...#...###.###.#.....##.....##.#.....##.#....#.##..##.#.....##.....#.#...#..###.#....##.#....##.#......
18 : ............#...##...###.###.##..##..###.#......#.....##.#.....##.#..###..#..##.#......#...##..###....###.#....##.#....##.#.....
19 : ...........#.##...##..##..##...#...#..###.#....#.#.....##.#.....##....#.##....##.#....#.##...#..#.#....###.#....##.#....##.#....
20 : ..........###..##...#...#...###.###....###.#..##..#.....##.#......#..###..#....##.#..###..###..##..#....###.#....##.#....##.#...
2917
*/


