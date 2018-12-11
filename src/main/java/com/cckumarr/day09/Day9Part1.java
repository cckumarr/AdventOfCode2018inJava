package main.java.com.cckumarr.day09;

import java.util.Collections;
import java.util.HashMap;

//--- Day 9: Marble Mania ---
public class Day9Part1 {
  public static void main(String args[]){

    HashMap<Integer,Long> players = new HashMap<>();
    int playersCount = 471;
    //for part 1
    int count = 72026;

    //for part 2
    //int count = 7202600;

    CustomDeque current=new CustomDeque(0);
    current.setNext(current);
    current.setPrevious(current);
    CustomDeque start = current;

    long sum=0;
    for(int i =1; i<=count; i++){
      if(i % 23 == 0){
        sum = i;
        for(int j=0;j<7;j++){
          current = current.getPrevious();
        }
        sum = sum + current.value;
        CustomDeque previous = current.getPrevious();
        CustomDeque next = current.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        if(players.get(i % playersCount) == null){
          players.put(i % playersCount, sum);
        } else{
          sum = sum + players.get(i % playersCount);
          players.put(i % playersCount, sum);
        }
        current=next;
      }
      else {
        CustomDeque node = new CustomDeque(i);
        current = current.getNext();
        CustomDeque next = current.getNext();
        current.setNext(node);
        node.setPrevious(current);
        node.setNext(next);
        next.setPrevious(node);
        current = node;
      }

      //for printing step by step
      /*System.out.println();
      CustomDeque loop = start;
      for(int k =0;k<=i; k++){
        System.out.print(" " + loop.value);
        loop = loop.getNext();
      }*/
    }
    System.out.println(Collections.max(players.values()));
  }
}
