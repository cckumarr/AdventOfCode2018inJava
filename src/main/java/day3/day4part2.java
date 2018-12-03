package main.java.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4part2 {
  public static void main(String args[]) throws FileNotFoundException {

  Scanner in = new Scanner(new File("day3input.txt"));
  String[][] integerarr = new String[1000][1000];
  int totalxs = 0;
  ArrayList<Integer> xarray = new ArrayList<>();
  ArrayList<Integer> yarray = new ArrayList<>();
  ArrayList<Integer> marray = new ArrayList<>();
  ArrayList<Integer> narray = new ArrayList<>();
  ArrayList<Integer> idarray = new ArrayList<>();

    while (in.hasNext()) {
    int x =0, y = 0, m = 0, n =0, id=0;



    String str = in.nextLine();
    String[] split = str.split(" ");

    id = Integer.parseInt(split[0].substring(1));
    idarray.add(id);

    String[] str2 = split[2].split(",");
    x = Integer.parseInt(str2[0]);
    xarray.add(x);
    y = Integer.parseInt(str2[1].substring(0,str2[1].length()-1));
    yarray.add(y);

    String[] str3 = split[3].split("x");
    m = Integer.parseInt(str3[0]);
    marray.add(m);
    n = Integer.parseInt(str3[1]);
    narray.add(n);

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


  boolean found = false;
  int count =0;
  while(count < xarray.size() && !found) {
    found = true;
    for (int i = yarray.get(count); i < yarray.get(count) + narray.get(count); i++) {
      for (int j = xarray.get(count); j < xarray.get(count) + marray.get(count); j++) {
        if (integerarr[j][i] == "x") {
          found = false;
        }
      }
    }
    if(found == true)
      System.out.println(idarray.get(count));
    count++;
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
    }
    System.out.println(totalxs);*/
}
}

//answer : 943
