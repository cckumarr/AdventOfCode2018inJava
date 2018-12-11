package main.java.com.cckumarr.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 10: The Stars Align ---
public class Day10Part1Attempt2 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day10input.txt"));

    //for test
    //int matrixSize = 31;
    //for input
    //int matrixSize = 60000;

    /*String[][] matrix = new String[matrixSize][matrixSize];
    for(int i=0;i<matrixSize;i++)
      for(int j=0; j<matrixSize; j++){
        matrix[j][i] = ".";
      }*/

    HashMap<Integer,Integer> xss = new HashMap<>();
    HashMap<Integer,Integer> yss = new HashMap<>();

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
    int count=0;
    while(numberOfsecs++ < 100000){
      if(numberOfsecs > 10875) {
        if (numberOfsecs % 10 == 0) {
          for (int i = 0; i < xs.size(); i++) {
            System.out.println("(" + xs.get(i) + "," + ys.get(i) + ")");
          }
        }
      }
      xss = new HashMap<>();
      yss = new HashMap<>();

      for(int i =0; i<xs.size(); i++) {
        xs.add(i, xs.get(i) + velocityxs.get(i));
        xs.remove(i+1);
        ys.add(i, ys.get(i) + velocityys.get(i));
        ys.remove(i+1);
      }

      for(int i =0; i<xs.size(); i++)
      {
        if(xss.get(xs.get(i)) == null){
          xss.put(xs.get(i),1);
        } else {
          xss.put(xs.get(i), xss.get(xs.get(i))+1);
        }
      }

      for(int i =0; i<xs.size(); i++)
      {
        if(yss.get(ys.get(i)) == null){
          yss.put(ys.get(i),1);
        } else {
          yss.put(ys.get(i), yss.get(ys.get(i))+1);
        }
      }

      if(xss.size() == 8){
        System.out.println();
      }

    }

    System.out.println();
  }
}
