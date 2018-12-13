package main.java.com.cckumarr.day11;

//--- Day 11: Chronal Charge ---
public class Day11Part2 {
  public static void main(String args[]) {
    //input
    int gridSerialNumber = 3613;

    int[][] powerMatrix = new int[300][300];
    int rackId;
    int powerLvl;

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

    int maxPower = Integer.MIN_VALUE;
    int maxX=0,maxY=0,maxnbyn=0;

    int count=1;
    while(count < 300) {
      System.out.println(count);
      for (int y = 0; y < 300 - count; y++) {
        for (int x = 0; x < 300 - count; x++) {
          int sum = 0;
          for (int ynbyn = y; ynbyn < y + count; ynbyn++) {
            for (int xnbyn = x; xnbyn < x + count; xnbyn++) {
              sum = sum + powerMatrix[xnbyn][ynbyn];
            }
          }
          if (sum > maxPower) {
            maxPower = sum;
            maxX = x;
            maxY = y;
            maxnbyn = count;
          }
        }
      }
      count++;
    }
    System.out.println(maxX +" "+maxY+" "+maxnbyn);
  }
}


//Answer : 233 93 13