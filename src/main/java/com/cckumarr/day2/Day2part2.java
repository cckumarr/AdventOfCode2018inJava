package main.java.com.cckumarr.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2part2 {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner in = new Scanner(new File("resources/day2input.txt"));
    ArrayList<String> arr = new ArrayList<>();
    while (in.hasNext()) {
      arr.add(in.nextLine());
    }
    arr.sort(String::compareTo);
    /*for(String s: arr){
      System.out.println(s);
    }*/
    Boolean found = false;
    int i=0;
    while(i<arr.size()-1 && !found){
      int diff = 0;
      int count =0;
      String answer="";
      for(char c : arr.get(i).toCharArray()){

        if(c != arr.get(i+1).charAt(count)){
          diff++;
        }else{
          answer = answer + c;
        }
        count++;
        if(diff >= 2)
          break;
      }
      if(diff == 1){
        System.out.println(arr.get(i) + " " + arr.get(i+1));
        System.out.println(answer);
        found = true;
      }
      i++;
    }
  }

}

//bvnfawcnyoeyudzrpgsldimtkj bvnfawcnyoeyudzrpgsleimtkj
//bvnfawcnyoeyudzrpgslimtkj

//answer : bvnfawcnyoeyudzrpgslimtkj