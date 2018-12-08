package main.java.com.cckumarr.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day7Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    ArrayList<Node> readyToBeProcessed = new ArrayList<>();
    ArrayList<Node> doneList = new ArrayList<>();
    HashMap<String,Node> mapOfNode = new HashMap<>();
    int numOfWorkers=5;   //2 for testing 5 for running given input
    int extraSeconds=60;   // 0 or 60
    Worker[] workers = new Worker[numOfWorkers];

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

    for(int i=0; i<numOfWorkers; i++){
      workers[i] = new Worker(".",0);
    }

    boolean done = false;
    boolean requirementsPassed = true;
    int count=0;
    System.out.println("sec   " + "w1 " + " w2" + " w3" +" w4" + " w5" + " done");
    while(!done) {
      System.out.print(String.format("%5d", count));
      for (Worker w : workers) {
        w.setSecondsLeft(w.getSecondsLeft()-1);
        if(w.getSecondsLeft()<=0) {
          if(w.getNodeName() != ".") {
            Node tobeaddedtodeonlist = mapOfNode.get(w.getNodeName());
            doneList.add(tobeaddedtodeonlist);
            for (Node checkReqs : tobeaddedtodeonlist.getConnectsTo()) {
              requirementsPassed = true;
              for (Node reqs : checkReqs.getRequirements()) {
                if (!doneList.contains(reqs)) {
                  requirementsPassed = false;
                  break;
                }
              }
              if (requirementsPassed) {
                if (!readyToBeProcessed.contains(checkReqs)) {
                  readyToBeProcessed.add(checkReqs);
                  Collections.sort(readyToBeProcessed);
                }
              }
            }
            w.setNodeName(".");
          }
          if(!readyToBeProcessed.isEmpty()) {
            Node n = readyToBeProcessed.remove(0);
            int seconds = n.getName().charAt(0) - 64 + extraSeconds;
            w.setNodeName(n.getName());
            w.setSecondsLeft(seconds);
          }
        }
        System.out.print(" " + w.getNodeName() + " ");
      }
      for(Node n : doneList){
        System.out.print(n.getName());
      }
      System.out.println();
      if(doneList.size() == mapOfNode.size())
        done=true;
      else
        count++;
    }
  }
}



// attempt 1 answer : 932
// order of steps : IOXZFSWAJPEQDUVLNYMHTBCRGK


// issues in code because an iterative approach to allocate workers was used when o openup 3 new elements ready to be processed 1 element when to the next second this caused everything to be delayed by 1 second, this could have been avoid by using simultaneous worker allocation.

//thats why the real answer is 1 minus of the solution gives in this particular case