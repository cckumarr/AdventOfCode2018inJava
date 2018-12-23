package main.java.com.cckumarr.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day13Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    //read input
    Scanner input = new Scanner(new File("resources/day13input.txt"));

    int arrayXSize = 155;
    int arrayYsize = 151;

    //for part2 test
    //int arrayXSize = 7;
    //int arrayYsize = 7;

    //char[][] trackMap = new char[arrayYsize][arrayXSize];
    char[][] originalTrackMap = new char[arrayYsize][arrayXSize];
    char[][] currentProcessingtrackMap = new char[arrayYsize][arrayXSize];
    char[][] nextStepTrackMap = new char[arrayYsize][arrayXSize];


    HashMap<String,String> currentCarDecisionAtIntersection = new HashMap<>();
    HashMap<String,String> nextStepCarDecisionAtIntersection = new HashMap<>();
    //hashmap of all the intersection locations
    HashMap<String,String> intersectionLocations = new HashMap<>();


    // init track map with spaces by default its nulls
    for(int i = 0; i<arrayYsize; i++) {
      for (int j = 0; j < arrayXSize; j++) {
        originalTrackMap[i][j] = ' ';
        currentProcessingtrackMap[i][j] = ' ';
        nextStepTrackMap[i][j] = ' ';
      }
    }

    //inputting lines straight up not using char by char
    //boc sof this every row will have a different end length
    int y=0;
    while(input.hasNext()){
      currentProcessingtrackMap[y] = input.nextLine().toCharArray();
      y++;
    }

    //printing out the track map if we got it correct
    for(int i = 0; i<arrayYsize; i++){
      for(int j =0; j<currentProcessingtrackMap[i].length; j++){
        System.out.print(currentProcessingtrackMap[i][j]);
      }
      System.out.println();
    }

    for(int i = 0; i<arrayYsize; i++){
      for(int j =0; j<currentProcessingtrackMap[i].length; j++){
        originalTrackMap[i][j] = currentProcessingtrackMap[i][j];
      }
    }

    //now to remove the carts from originalTrackMap and populate the intersectionLocations
    for(int i = 0; i<arrayYsize; i++){
      for(int j =0; j<originalTrackMap[i].length; j++){
        char c = originalTrackMap[i][j];
        if('+'== c) {
          String location = i + "," + j;
          intersectionLocations.putIfAbsent(location, "+");
        }
        if(c == '>' || c =='<' || c == 'v' || c =='^'){
          //check for symbols on the right anf left
          if(j-1 >= 0 && j+1 < originalTrackMap[i].length){
            if((originalTrackMap[i][j-1] == '-' || originalTrackMap[i][j-1] == '+'
                || originalTrackMap[i][j-1] == '/' || originalTrackMap[i][j-1] == '\\')
                && (originalTrackMap[i][j+1] == '-' || originalTrackMap[i][j+1] == '\\'
                || originalTrackMap[i][j+1] == '+' || originalTrackMap[i][j+1] == '/')){
              originalTrackMap[i][j] = '-';
            }
          }
          else{
            if(j-1 < 0){
              //no use case for this
            }
            if(j+1 > originalTrackMap[i].length){
              //no use case of this too
            }
          }

          //check for symbols up and down
          if(i-1 >= 0 && i+1 < arrayYsize){
            if((originalTrackMap[i-1][j] == '|' || originalTrackMap[i-1][j] == '+'
                || originalTrackMap[i-1][j] == '/' || originalTrackMap[i-1][j] == '\\')
                && (originalTrackMap[i+1][j] == '|' || originalTrackMap[i+1][j] == '/'
                || originalTrackMap[i+1][j] == '\\' || originalTrackMap[i+1][j] == '+')){
              originalTrackMap[i][j] = '|';
            }
          }
        }
      }
    }

    //printing out the original track map after removing the cars
    System.out.println("original after cart removal.");
    for(int i = 0; i<arrayYsize; i++){
      for(int j =0; j<originalTrackMap[i].length; j++){
        System.out.print(originalTrackMap[i][j]);
      }
      System.out.println();
    }

    int cartCount = Integer.MAX_VALUE;
    String cartCountLocation="";
    while(cartCount>1){
      //reinit hashmap
      nextStepCarDecisionAtIntersection = new HashMap<>();
      for(int i = 0; i<arrayYsize; i++){
        for(int j =0; j<currentProcessingtrackMap[i].length; j++){
          nextStepTrackMap[i][j] = originalTrackMap[i][j];
        }
      }
      cartCount=0;

      for(int i = 0; i<arrayYsize; i++){
        for(int j =0; j<currentProcessingtrackMap[i].length; j++){

          String compare = String.valueOf(currentProcessingtrackMap[i][j]);
          String location = i + "," + j;

          //nextStepTrackMap[i][j] = originalTrackMap[i][j];
          if("<>^v".contains(compare)){
            if(intersectionLocations.get(location) != null){
              String decision = currentCarDecisionAtIntersection.get(location);

              if(decision==null || decision.equals("left")){
                if(compare.equals("v")){
                  currentProcessingtrackMap[i][j]='>';
                }
                if(compare.equals("^")){
                  currentProcessingtrackMap[i][j]='<';
                }
                if(compare.equals(">")){
                  currentProcessingtrackMap[i][j]='^';
                }
                if(compare.equals("<")){
                  currentProcessingtrackMap[i][j]='v';
                }
                currentCarDecisionAtIntersection.put(location,"straight");
                decision = "left";
              }
              if(decision.equals("straight")){
                currentCarDecisionAtIntersection.put(location,"right");
              }
              if(decision.equals("right")){
                if(compare.equals("v")){
                  currentProcessingtrackMap[i][j]='<';
                }
                if(compare.equals("^")){
                  currentProcessingtrackMap[i][j]='>';
                }
                if(compare.equals(">")){
                  currentProcessingtrackMap[i][j]='v';
                }
                if(compare.equals("<")){
                  currentProcessingtrackMap[i][j]='^';
                }
                currentCarDecisionAtIntersection.put(location,"left");
              }
            }
            if(originalTrackMap[i][j] == '\\'){
              if(compare.equals("^")){
                currentProcessingtrackMap[i][j]='<';
              }
              if(compare.equals("v")){
                currentProcessingtrackMap[i][j]='>';
              }
              if(compare.equals(">")){
                currentProcessingtrackMap[i][j]='v';
              }
              if(compare.equals("<")){
                currentProcessingtrackMap[i][j]='^';
              }
            }

            if(originalTrackMap[i][j] == '/'){
              if(compare.equals("^")){
                currentProcessingtrackMap[i][j]='>';
              }
              if(compare.equals("v")){
                currentProcessingtrackMap[i][j]='<';
              }
              if(compare.equals(">")){
                currentProcessingtrackMap[i][j]='^';
              }
              if(compare.equals("<")){
                currentProcessingtrackMap[i][j]='v';
              }
            }

            compare = String.valueOf(currentProcessingtrackMap[i][j]);
            int movetox=i,movetoy=j;
            char direction=' ';
            if("<".equals(compare)){
              movetoy = j-1;
              direction = '<';
            }
            if(">".equals(compare)){
              movetoy = j+1;
              direction = '>';
            }
            if("^".equals(compare)){
              movetox = i-1;
              direction = '^';
            }
            if("v".equals(compare)){
              movetox = i+1;
              direction = 'v';
            }
            if("<>^v".contains(String.valueOf(nextStepTrackMap[movetox][movetoy]))){
              nextStepTrackMap[movetox][movetoy]= originalTrackMap[movetox][movetoy];
              System.out.println("crash at :" + movetoy + " "+ movetox);
            }else{
              nextStepTrackMap[movetox][movetoy]=direction;
              nextStepCarDecisionAtIntersection.put(movetox+","+movetoy,
                  currentCarDecisionAtIntersection.get(location));
            }
          }
        }
      }

      currentCarDecisionAtIntersection = nextStepCarDecisionAtIntersection;
      for(int i = 0; i<arrayYsize; i++){
        for(int j =0; j<currentProcessingtrackMap[i].length; j++){
          currentProcessingtrackMap[i][j] = nextStepTrackMap[i][j];
          String compare = String.valueOf(currentProcessingtrackMap[i][j]);
          if("<>^v".contains(compare)){
            cartCount++;
            if(cartCount == 1){
              cartCountLocation = j +","+i;
            }
          }
          //System.out.print(currentProcessingtrackMap[i][j]);
        }
        //System.out.println();
      }
      System.out.println(cartCount);
      if(cartCount == 1) {
        for (int i = 0; i < arrayYsize; i++) {
          for (int j = 0; j < currentProcessingtrackMap[i].length; j++) {
            System.out.print(currentProcessingtrackMap[i][j]);
          }
          System.out.println();
        }
      }
    }
    System.out.println("cartCountLocation : " + cartCountLocation);
  }
}



//answer = 92,42