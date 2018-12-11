package main.java.com.cckumarr.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day8Part1 {
  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new File("resources/day8input.txt"));
    String[] inputVar = input.nextLine().split(" ");
    //String[] inputVar = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2".split(" ");

    Stack<Node> bigOldStackOfNodes = new Stack<>();

    int count=0;
    Node currentNode;
    int nodeCount=0;
    int sum=0;
    while(count < inputVar.length){

      if(bigOldStackOfNodes.isEmpty() || bigOldStackOfNodes.peek().getChildNodes() !=0){
        int childnodes = Integer.parseInt(inputVar[count]);
        count++;
        int metadataEntries = Integer.parseInt(inputVar[count]);
        count++;

        currentNode = new Node(nodeCount,childnodes,metadataEntries);
      } else{
        currentNode = bigOldStackOfNodes.pop();
      }

      if(currentNode.getChildNodes() == 0){
        int metadata = currentNode.getMetadataEntries();
        for(int i =0; i<metadata; i++){
          sum = sum + Integer.parseInt(inputVar[count]);
          count++;
        }
        if(!bigOldStackOfNodes.isEmpty()){
          Node n = bigOldStackOfNodes.pop();
          n.childNodesMinus1();
          bigOldStackOfNodes.push(n);
        }
      }
      else{
        bigOldStackOfNodes.push(currentNode);
      }
    }
    System.out.println(sum);
  }
}
