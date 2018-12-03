package main.java.day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Day 1: Chronal Calibration
public class day1 {
  public static void main(String args[]) throws IOException {
    Scanner scanner = new Scanner(new File("day1input.txt"));
    int frequency = 0;

    while(scanner.hasNextInt()) {
      frequency += scanner.nextInt();
    }

    System.out.println(frequency);
  }
}


//answer 513