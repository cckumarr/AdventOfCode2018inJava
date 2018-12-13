package main.java.com.cckumarr.day11;

//--- Day 11: Chronal Charge ---
public class Day11Part1 {
  public static void main(String args[]) {
    //input
    int gridSerialNumber = 3613;

    int[][] powerMatrix = new int[300][300];
    int rackId;
    int powerLvl;

    // loop over each cell and add at powerlvl
    for(int y = 0; y < 300; y++){
      for(int x = 0; x< 300; x++){
        rackId =0;
        powerLvl =0;
        rackId = x + 10;
        powerLvl = ((rackId * y) + gridSerialNumber) * rackId;
        if(powerLvl > 1000);
        {
          powerLvl = powerLvl % 1000;
        }
        if(powerLvl > 100)
          powerLvl = powerLvl/100;
        else
          powerLvl=0;
        powerLvl -= 5;
        powerMatrix[x][y] = powerLvl;
      }
    }

    //find the 3x3 with the max powerlvl
    int maxSum = Integer.MIN_VALUE;
    int maxX=0,maxY=0;

    for(int y = 0; y < 297; y++){
      for(int x = 0; x< 297; x++){
        int sum = 0;
        for(int  y3by3 = y; y3by3 < y+3; y3by3++) {
          for (int x3by3 = x; x3by3 < x+3; x3by3++) {
            sum = sum + powerMatrix[x3by3][y3by3];
          }
        }
        if(sum > maxSum){
          maxSum = sum;
          maxX = x;
          maxY = y;
        }
      }
    }
    System.out.println(maxSum +" "+maxX +" "+maxY);
  }
}


// 29 33 45
// 30 21 61


//Answer : 20 54 with max power of 30 for input 3613