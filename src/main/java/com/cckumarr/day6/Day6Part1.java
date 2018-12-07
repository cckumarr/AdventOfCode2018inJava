package main.java.com.cckumarr.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 6: Chronal Coordinates ---
public class Day6Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day6input.txt"));

    ArrayList<Integer> infiniteNumbers = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();

    int[][] points = new int[345][345];
    int[] xs = new int[50];  //number of points should have made this an arraylist
    int[] ys = new int[50];

    int count=0;
    while(input.hasNext()){
      String str = input.nextLine();
      String[] split = str.split(", ");

      int x = Integer.parseInt(split[0]);
      int y = Integer.parseInt(split[1]);

      //points[x][y] = count;
      xs[count] = x;
      ys[count] = y;
      count++;
    }

    /*for(int i=0; i<345; i++ ){
      for(int j=0; j<345; j++){
        System.out.print(points[j][i]);
      }
      System.out.println();
    }
    System.out.println();*/

    //traverse through the loop and find the point with the shortest distance
    for(int i=0; i<345; i++){
      for(int j=0; j<345;j++){
        int x2 = j;
        int y2 = i;
        int counter=0;
        int min=Integer.MAX_VALUE;
        while(counter < xs.length){
          int temp = Math.abs(x2 - xs[counter]) + Math.abs(y2 - ys[counter]);
          if(temp == min){
            points[x2][y2] = 0;
          }
          if(temp < min){
            min = temp;
            points[x2][y2] = counter+1;
          }
          counter++;
        }

        /*for(int q=0; q<345; q++ ){
          for(int w=0; w<345; w++){
            System.out.print(points[w][q]);
          }
          System.out.println();
        }
        System.out.println();*/
      }

    }

    for(int i=0; i<345; i++ ){
      for(int j=0; j<345; j++){
        System.out.print(points[j][i]);
      }
      System.out.println();
    }


    //count all the outer cells and then add them to do not count list these are infinite
    infiniteNumbers.add(0); //added 0 cos we dont care about 0
    for(int i =0; i< points.length; i++){
      if(!infiniteNumbers.contains(points[i][0])){
        infiniteNumbers.add(points[i][0]);
      }
      if(!infiniteNumbers.contains(points[0][i])){
        infiniteNumbers.add(points[0][i]);
      }
      if(!infiniteNumbers.contains(points[i][points.length-1])){
        infiniteNumbers.add(points[i][points.length-1]);
      }
      if(!infiniteNumbers.contains(points[points.length-1][i])){
        infiniteNumbers.add(points[points.length-1][i]);
      }
    }

    //count all cells and add the ones thats not infinite
    for(int i =0; i<points.length;i++){
      for(int j =0; j<points.length;j++){
        int current = points[j][i];
        if(infiniteNumbers.contains(current)){
          continue;
        }else{
          if(map.get(current)==null){
            map.put(current,1);
          }
          else{
            map.put(current,map.get(current)+1);
          }
        }
      }
    }

    System.out.println(Collections.max(map.values()));
  }
}



//answer : 2917