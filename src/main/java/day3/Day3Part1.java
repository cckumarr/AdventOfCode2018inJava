package main.java.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//--- Day 3: No Matter How You Slice It ---
public class Day3Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("day3input.txt"));
    String[][] integerarr = new String[1000][1000];
    int totalxs = 0;

    while (in.hasNext()) {
      int x =0, y = 0, m = 0, n =0, id=0;
      String str = in.nextLine();
      String[] split = str.split(" ");

      id = Integer.parseInt(split[0].substring(1));

      String[] str2 = split[2].split(",");
      x = Integer.parseInt(str2[0]);
      y = Integer.parseInt(str2[1].substring(0,str2[1].length()-1));

      String[] str3 = split[3].split("x");
      m = Integer.parseInt(str3[0]);
      n = Integer.parseInt(str3[1]);

      for(int i = y; i<y+n; i++){
        for(int j = x; j < x+m; j++){
          if(integerarr[j][i] == null){
            integerarr[j][i] = String.valueOf(id);
          }else if(integerarr[j][i] != "x" && integerarr[j][i] != null) {
            integerarr[j][i] = "x";
            totalxs++;
          }
          }

        }
      }


      //loop from x to m
      //loop from
      //System.out.println(id + " "+ x + " " + y + " " +  m + " " + n);


    /*for(int i = 0; i<10; i++){
      for(int j = 0; j < 10; j++){
        if(integerarr[j][i] == null)
          System.out.print(0);
        else
          System.out.print(integerarr[j][i]);
      }
      System.out.println();
    }*/
    System.out.println(totalxs);
  }
}

//#1 @ 185,501: 17x15
//split, substring after #, [3] substring 0 to n-1 thus dropping the :, split on x



//Answer : 121163


