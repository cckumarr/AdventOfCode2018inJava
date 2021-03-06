package main.java.com.cckumarr.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 10: The Stars Align ---
//this code works only for the testinput, solved through non programing bruteforce in attempt2
public class Day10Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day10testinput.txt"));

    //for test
    int matrixSize = 31;
    //for input
    //int matrixSize = 60000;

    HashMap<Integer,Integer> xss = new HashMap<>();
    HashMap<Integer,Integer> yss = new HashMap<>();

    //start the matrix with .'s
    String[][] matrix = new String[matrixSize][matrixSize];
    for(int i=0;i<matrixSize;i++)
      for(int j=0; j<matrixSize; j++){
        matrix[j][i] = ".";
      }

    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();

    ArrayList<Integer> velocityxs = new ArrayList<>();
    ArrayList<Integer> velocityys = new ArrayList<>();

    //read all the coordinates and velocities inputs into lists
    while(input.hasNext()){
      String str = input.nextLine();

      xs.add(Integer.parseInt(str.substring(str.indexOf("<")+1, str.indexOf(",")).trim()));
      ys.add(Integer.parseInt(str.substring(str.indexOf(",")+1, str.indexOf(">")).trim()));

      velocityxs.add(Integer.parseInt(str.substring(str.lastIndexOf("<")+1, str.lastIndexOf(",")).trim()));
      velocityys.add(Integer.parseInt(str.substring(str.lastIndexOf(",")+1, str.lastIndexOf(">")).trim()));
    }

    int numberOfsecs = 0;
    int count=0;
    while(numberOfsecs++ < 3){
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

      for(int i=0;i<matrixSize;i++)
        for(int j=0; j<matrixSize; j++){
          matrix[j][i] = ".";
        }

      //00 is at 15,15
      for(int i =0; i<xs.size(); i++){
        matrix[10+xs.get(i)][10+ys.get(i)] = "#";
      }

      for(int i=0;i<matrixSize;i++) {
        System.out.println();
        for (int j = 0; j < matrixSize; j++) {
          System.out.print(matrix[j][i]);
        }
      }
    }
  }
}
