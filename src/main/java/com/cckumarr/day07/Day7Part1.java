package main.java.com.cckumarr.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//--- Day 7: The Sum of Its Parts ---
public class Day7Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    ArrayList<Node> readyToBeProcessed = new ArrayList<>();
    ArrayList<Node> doneList = new ArrayList<>();
    HashMap<String,Node> mapOfNode = new HashMap<>();

    //scan and add all the elements to the map
    Scanner input = new Scanner(new File("resources/day7input.txt"));
    while(input.hasNext()){
      String str = input.nextLine();
      String[] split = str.split(" ");

      String prev = split[1];
      String next = split[7];
      Node prevNode=null,nextNode=null;

      if(mapOfNode.get(prev) == null){
        prevNode = new Node(prev);
        mapOfNode.put(prev,prevNode);
      }else{
        prevNode = mapOfNode.get(prev);
      }

      if(mapOfNode.get(next) == null){
        nextNode = new Node(next);
        mapOfNode.put(next,nextNode);
      }else{
        nextNode = mapOfNode.get(next);
      }

      prevNode.setConnectsTo(nextNode);
      nextNode.setRequirements(prevNode);

    }

    //find the nodes with no requirements
    for(Node n : mapOfNode.values()){
      if(n.getRequirements().isEmpty()){
        if(!readyToBeProcessed.contains(n)) {
          readyToBeProcessed.add(n);
        }
      }
    }
    Collections.sort(readyToBeProcessed);

    /*add c to done
    remove c from readytobeprocessed
    loop through c's connectsto
      check to if the requirements of that node is fulfilled
      add element to readytobeprocessed
    sort the readytobeprocessed*/
    while(!readyToBeProcessed.isEmpty()){
      Node node = readyToBeProcessed.remove(0);
      System.out.print(node.getName());
      doneList.add(node);
      Boolean contains;
      for(Node n : node.getConnectsTo()){
        contains=true;
        for(Node requirementsCheck : n.getRequirements()){
          if(!doneList.contains(requirementsCheck)){
            contains=false;
            break;
          }
        }
        if(contains==true){
          if(!readyToBeProcessed.contains(n)) {
            readyToBeProcessed.add(n);
          }
        }
      }
      Collections.sort(readyToBeProcessed);
    }
  }
}


//Answer : IOFSJQDUWAPXELNVYZMHTBCRGK