package main.java.com.cckumarr.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day8Part2 {
  public static void main(String args[]) throws FileNotFoundException {
    Day8Part2 day8Part2 = new Day8Part2();
    Scanner input = new Scanner(new File("resources/day8input.txt"));
    String[] inputStr = input.nextLine().split(" ");
    //String[] inputStr = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2".split(" ");
    ArrayList<Integer> inputInt = new ArrayList<>();

    for(String s : inputStr){
      inputInt.add(Integer.parseInt(s));
    }

    Node2 node=null;
    Stack<Node2> s = new Stack<>();
    boolean done=false;
    int count =0;
    int nodeCount=0;

    node = new Node2(nodeCount++,inputInt.get(count++),inputInt.get(count++));
    s.push(node);

    while(count < inputStr.length){
      Node2 currentNode =null;

      if (s.peek().numChildLeftToProcess == 0) {
        currentNode = s.pop();
        for(int i=0;i<currentNode.numOfMetaDataEntries;i++){
          currentNode.addMetadata(inputInt.get(count++));
        }
        if(!s.isEmpty()) {
          Node2 parent = s.pop();
          parent.childMinus1();
          s.push(parent);
        }
      }
      else{
        currentNode = new Node2(nodeCount++,inputInt.get(count++),inputInt.get(count++));
        Node2 parent = s.pop();
        parent.addChild(currentNode);
        s.push(parent);
        s.push(currentNode);
      }
    }
    System.out.println(day8Part2.calculateMetaVal(node));
  }

  public int calculateMetaVal(Node2 root){
    if(root == null){
      return 0;
    }
    int sum = 0;

    //if no children then return sum of metadata
    if(root.getChildren().isEmpty()){
      for(Integer i : root.metadata){
        sum = sum + i;
      }
      return sum;
    }

    //if children then return sum of
    for(Integer n : root.metadata){
      if(n==0 || n>root.children.size())
        continue;
      sum = sum + calculateMetaVal(root.getChildren().get(n-1));
    }
    return sum;
  }
}



//answer = 33649
