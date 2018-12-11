package main.java.com.cckumarr.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day6Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day6input.txt"));

    ArrayList<Integer> infiniteNumbers = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int matrixSize = 345;
    int totaldistance = 10000;

    String[][] points = new String[matrixSize][matrixSize];
    int[] xs = new int[50];  //number of points should have made this an arraylist
    int[] ys = new int[50];

    int count = 0;
    while (input.hasNext()) {
      String str = input.nextLine();
      String[] split = str.split(", ");

      int x = Integer.parseInt(split[0]);
      int y = Integer.parseInt(split[1]);

      //points[x][y] = count;
      xs[count] = x;
      ys[count] = y;
      count++;
    }

    int hashCount =0;

    //traverse through the loop and add up all the distances
    for (int i = 0; i < matrixSize; i++) {
      for (int j = 0; j < matrixSize; j++) {
        int x2 = j;
        int y2 = i;
        int counter = 0;
        int sum = 0;
        while (counter < xs.length) {
          points[x2][y2]=".";
          int temp = Math.abs(x2 - xs[counter]) + Math.abs(y2 - ys[counter]);
          sum +=temp;
          if (sum >= totaldistance) {
            counter++;
            continue;
          }
          counter++;
        }
        if(sum < totaldistance){
          hashCount++;
          points[x2][y2]="#";
        }
      }
    }

    for(int i =0; i<points.length; i++){
      for(int j=0; j<points.length; j++){
        System.out.print(points[j][i]);
      }
      System.out.println();
    }

    System.out.println(hashCount);
  }
}



//Answer : 44202