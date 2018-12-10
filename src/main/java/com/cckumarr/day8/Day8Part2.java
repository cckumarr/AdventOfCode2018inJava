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

    //set the root node up
    node = new Node2(nodeCount++,inputInt.get(count++),inputInt.get(count++));
    s.push(node);

    //setting up the tree with values
    //adding node to stack to keep track of the parents
    while(count < inputStr.length){
      Node2 currentNode =null;

      //if no child left to process on the topmost item in the stack
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

  //recursive calculate the metadata of the root
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


// 1st to n-1th try = 0
// answer nth try= 33649

/*
notes to self:
spent a lot of time on this because of an edge case(read as silly mistake) that i did not catch, it worked fine for the testinput,
in line 71 i was checking for n>= root.children.size()
that is if a metadata with a value on where n is equal to the number of childrens size my code was dropping that
regularly this would be the ideal case but here we are doing a get of n-1 line 73
because of which we were dropping the metadata with the last child, because of which i was always getting an answer of 0

could have used a queue instead of an arraylist to store the split input, by doing that would have avoided the count business
*/
